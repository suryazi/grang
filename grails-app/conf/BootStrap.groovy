import grails.converters.JSON

import com.grang.Android
import com.grang.Battery
import com.grang.Camera
import com.grang.Connectivity
import com.grang.Display
import com.grang.Hardware
import com.grang.Phone
import com.grang.PhoneDetail
import com.grang.SizeAndWeight
import com.grang.Storage
import com.grang.Book

class BootStrap {

	def grailsApplication

    def init = { servletContext ->

		new Book(title:'Title1', author:'Ben', price:10).save(flush:true, failOnError:true)
    	new Book(title:'Title2', author:'Author', price:20).save(flush:true, failOnError:true)

    	JSON.registerObjectMarshaller( Phone ) { Phone phone ->
			return [
					age : phone.age,
					id : phone.phoneId,
					imageUrl : phone.imageUrl,
					name : phone.name,
					snippet : phone.snippet
			]
		}
		
		JSON.registerObjectMarshaller( PhoneDetail ) { PhoneDetail phoneDetail ->
			return [
				additionalFeatures: phoneDetail.additionalFeatures,
				android: phoneDetail.android,
				availability: phoneDetail.availability,
				battery: phoneDetail.battery,
				camera: phoneDetail.camera,
				connectivity: phoneDetail.connectivity,
				description: phoneDetail.description,
				display: phoneDetail.display,
				hardware: phoneDetail.hardware,
				id: phoneDetail.phoneId,
				images: phoneDetail.images,
				name: phoneDetail.name,
				sizeAndWeight: phoneDetail.sizeAndWeight,
				storage: phoneDetail.storage
				]
			}
		
		JSON.registerObjectMarshaller( Camera ) { Camera camera ->
			return [
					primary : camera.primaryCamera,
					features : camera.features,
			]
		}
		
		File phonesFolder = grailsApplication.mainContext.getResource("/phonesJson").file
		
		phonesFolder.listFiles().each { File file ->
			
			if(file.name.equals("phones.json")){
				
				def jsonPhones = grails.converters.JSON.parse(file.text)
				jsonPhones.each {
					Phone phone = new Phone(it)
					phone.phoneId = it.id
					phone.save(flush:true, failOnError:true)
				}
				
			} else {

				def jsonPhoneDetail = grails.converters.JSON.parse(file.text)

				PhoneDetail phoneDetail = new PhoneDetail(jsonPhoneDetail)
				phoneDetail.phoneId = jsonPhoneDetail.id

				phoneDetail.setAndroid(new Android(jsonPhoneDetail.android))
				phoneDetail.setBattery(new Battery(jsonPhoneDetail.battery))
				
				Camera camera = new Camera(jsonPhoneDetail.camera)
				camera.primaryCamera = jsonPhoneDetail.camera.primary
				phoneDetail.setCamera(camera)
				
				phoneDetail.setConnectivity(new Connectivity(jsonPhoneDetail.connectivity))
				phoneDetail.setDisplay(new Display(jsonPhoneDetail.display))
				phoneDetail.setHardware(new Hardware(jsonPhoneDetail.hardware))
				phoneDetail.setSizeAndWeight(new SizeAndWeight(jsonPhoneDetail.sizeAndWeight))
				phoneDetail.setStorage(new Storage(jsonPhoneDetail.storage))

				phoneDetail.save(flush:true, failOnError:true)

			}
		}
    }
	
    def destroy = {
		
    }
	
}

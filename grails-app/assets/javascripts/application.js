// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require jquery/dist/jquery
//= require angular/angular
//= require angular-animate/angular-animate
//= require angular-resource/angular-resource
//= require angular-route/angular-route
//= require grangApp
//= require bootstrap/dist/js/bootstrap
//= require app/animations
//= require app/app
//= require app/controller.js
//= require app/directives.js
//= require app/filters.js
//= require app/services.js
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
    (function($) {
        $('#spinner').ajaxStart(function() {
            $(this).fadeIn();
        }).ajaxStop(function() {
            $(this).fadeOut();
        });
    })(jQuery);
}
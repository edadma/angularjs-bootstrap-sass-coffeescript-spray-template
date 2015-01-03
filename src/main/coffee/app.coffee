app = angular.module( 'app', ['ngRoute'] )

app.config( ['$routeProvider', ($routeProvider) ->
	$routeProvider.
		when('/',
			templateUrl: 'home.html').
		when('/about',
			templateUrl: 'about.html').
		when('/contact',
			templateUrl: 'contact.html').
		otherwise(
			redirectTo: '/')
	] )
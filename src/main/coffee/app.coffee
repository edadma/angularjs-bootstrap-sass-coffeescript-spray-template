app = angular.module( 'app', ['ngRoute'] )

app.config( ['$routeProvider', ($routeProvider) ->
	$routeProvider.
		when('/',
			templateUrl: 'home.html'
			activetab: 'home').
		when('/about',
			templateUrl: 'about.html'
			activetab: 'about').
		when('/contact',
			templateUrl: 'contact.html'
			activetab: 'contact').
		otherwise(
			redirectTo: '/')
	] )

app.controller( 'bodyCtrl', ($scope, $route) ->
		$scope.$route = $route
	)
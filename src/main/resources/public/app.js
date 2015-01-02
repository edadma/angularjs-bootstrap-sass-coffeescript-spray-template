angular.module( 'app', ['ngRoute'] )
	.config( ['$routeProvider', function($routeProvider) {
		$routeProvider.
			when('/home', {
				templateUrl: 'home.html',
			}).
			when('/about', {
				templateUrl: 'about.html',
			}).
			when('/contact', {
				templateUrl: 'contact.html',
			}).
			otherwise({
				redirectTo: '/home'
			});
	}]);
angular.module('xanbitApp', ['pascalprecht.translate']);

angular.module('xanbitApp').run(['$rootScope', function($rootScope) {
	  $rootScope.lang = 'en';
	}])
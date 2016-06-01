angular.module('xanbitApp').config(['$translateProvider', function($translateProvider) {

	  $translateProvider
	  .useStaticFilesLoader({
	    prefix: '/assets/translations/locale-',
	    suffix: '.json'
	  })
	  .preferredLanguage('sv')
	  .useMissingTranslationHandlerLog();
	}]);
app.controller("movieAddCtrl", function($scope, $http) {
	$scope.showSearch = false;
	
	$scope.movie = {};
	$scope.master = {};
	$scope.success = "";
	
	$scope.save = function(isValid) {
		$scope.success = "";
		if(isValid) {
			$http.post("movie/", $scope.movie).then(function(response) {
		        $scope.success = response.data.message;
		        $scope.reset($scope.form);
		    });
		}
	};

	$scope.reset = function(form) {
		if (form) {
			form.$setPristine();
			form.$setUntouched();
		}
		$scope.movie = angular.copy($scope.master);
	};

	$scope.reset();
});
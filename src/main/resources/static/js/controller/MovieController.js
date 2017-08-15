app.controller("movieCtrl", function($scope, $http, $timeout) {
    $scope.get = function(limit) {
    	$scope.method = "page";
    	$http.get("movie/page/"+limit).then(function(response) {
	        $scope.movies = response.data;
	    });
    }
    
    $scope.find = function(val, limit) {
    	if(val != "") {
    		$scope.method = "search";
    		$http.get("movie/search/"+val+"/"+limit).then(function(response) {
        		$scope.movies = response.data;
    		});
    	}
    }
    
    $scope.topRated = function(limit) {
    	$scope.method = "rating";
    	$http.get("movie/rating/"+limit).then(function(response) {
        	$scope.movies = response.data;
    	});
    }
    
    $scope.page = function(limit) {
    	if($scope.method == "page") {
    		$scope.get(limit);
    	} else if($scope.method == "search") {
    		$scope.find(limit);
    	} else if($scope.method == "rating") {
    		$scope.topRated(limit);
    	}
    }
    
    $scope.getNumber = function(num) {
    	return new Array(num);
    }
    
    $scope.get(1);
    $scope.showSearch = true;
});
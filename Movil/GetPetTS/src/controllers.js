/// <reference path="../typings/tsd.d.ts" />
angular.module('starter.controllers', [])
    .controller('AppCtrl', function ($scope, $ionicModal, $timeout) {
    // With the new view caching in Ionic, Controllers are only called
    // when they are recreated or on app start, instead of every page change.
    // To listen for when this page is active (for example, to refresh data),
    // listen for the $ionicView.enter event:
    //$scope.$on('$ionicView.enter', function(e) {
    //});
    $scope.loginData = {};
    $ionicModal.fromTemplateUrl('templates/login.html', {
        scope: $scope
    }).then(function (modal) {
        $scope.modal = modal;
    });
    $scope.closeLogin = function () {
        $scope.modal.hide();
    };
    $scope.login = function () {
        $scope.modal.show();
    };
    $scope.doLogin = function () {
        console.log('Doing login', $scope.loginData);
        $timeout(function () {
            $scope.closeLogin();
        }, 1000);
    };
})
    .controller('PlaylistsCtrl', function ($scope) {
    $scope.playlists = [
        { title: 'Reggae', id: 1 },
        { title: 'Chill', id: 2 },
        { title: 'Dubstep', id: 3 },
        { title: 'Indie', id: 4 },
        { title: 'Rap', id: 5 },
        { title: 'Cowbell', id: 6 }
    ];
})
    .controller('PlaylistCtrl', function ($scope, $stateParams) {
})
    .controller('UsrRegCtrl', function ($scope, $state, $cordovaGeolocation) {
    var options = { timeout: 10000, enableHighAccuracy: true };
    $cordovaGeolocation.getCurrentPosition(options).then(function (position) {
        var latLng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
        var mapOptions = {
            center: latLng,
            zoom: 15,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        $scope.map = new google.maps.Map(document.getElementById("map"), mapOptions);
        google.maps.event.addListenerOnce($scope.map, 'idle', function () {
            var marker = new google.maps.Marker({
                map: $scope.map,
                animation: google.maps.Animation.DROP,
                position: latLng
            });
            var infoWindow = new google.maps.InfoWindow({
                content: "Here I am!"
            });
            google.maps.event.addListener(marker, 'click', function () {
                infoWindow.open($scope.map, marker);
            });
        });
    }, function (error) {
        console.log("Could not get location");
    });
})
    .controller('BrowseCtrl', function ($scope, $cordovaCamera) {
    $scope.takePicture = function () {
        var options = {
            quality: 75,
            destinationType: Camera.DestinationType.DATA_URL,
            sourceType: Camera.PictureSourceType.CAMERA,
            allowEdit: true,
            encodingType: Camera.EncodingType.JPEG,
            targetWidth: 500,
            targetHeight: 500,
            popoverOptions: CameraPopoverOptions,
            saveToPhotoAlbum: false
        };
        $cordovaCamera.getPicture(options).then(function (imageData) {
            $scope.imgURI = "data:image/jpeg;base64," + imageData;
        }, function (err) {
        });
    };
})
    .controller('RepPetLostCtrl', function ($scope, $state, $cordovaGeolocation, $cordovaBarcodeScanner) {
    var options = { timeout: 10000, enableHighAccuracy: true };
    $cordovaGeolocation.getCurrentPosition(options).then(function (position) {
        var latLng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
        var mapOptions = {
            center: latLng,
            zoom: 15,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        $scope.map = new google.maps.Map(document.getElementById("map2"), mapOptions);
        google.maps.event.addListenerOnce($scope.map, 'idle', function () {
            var marker = new google.maps.Marker({
                map: $scope.map,
                animation: google.maps.Animation.DROP,
                position: latLng
            });
            var infoWindow = new google.maps.InfoWindow({
                content: "Here I am!"
            });
            google.maps.event.addListener(marker, 'click', function () {
                infoWindow.open($scope.map, marker);
            });
        });
    }, function (error) {
        console.log("Could not get location");
    });
    $scope.scanBarcode = function () {
        $cordovaBarcodeScanner.scan().then(function (imageData) {
            alert(imageData.text);
            console.log("Barcode Format -> " + imageData.format);
            console.log("Cancelled -> " + imageData.cancelled);
        }, function (error) {
            console.log("An error happened -> " + error);
        });
    };
});
//# sourceMappingURL=controllers.js.map
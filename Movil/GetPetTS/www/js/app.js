/**
 * Created by Alexeis on 29 jun 2016.
 */
/// <reference path="../typings/tsd.d.ts" />
// Ionic Starter App
// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
// 'starter.controllers' is found in controllers.js
angular.module('starter', ['ionic', 'starter.controllers', 'starter.services', 'ngCordova'])
    .run(function ($ionicPlatform) {
    $ionicPlatform.ready(function () {
        // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
        // for form inputs)
        if (window.cordova && window.cordova.plugins.Keyboard) {
            cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
            cordova.plugins.Keyboard.disableScroll(true);
        }
        if (window.StatusBar) {
            // org.apache.cordova.statusbar required
            //StatusBar.styleDefault();
            StatusBar.overlaysWebView(false);
            StatusBar.backgroundColorByHexString("#2c64c4");
        }
    });
})
    .config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider
        .state('app', {
        url: '/app',
        abstract: true,
        templateUrl: 'templates/menu.html',
        controller: 'AppCtrl'
    })
        .state('app.search', {
        url: '/search',
        views: {
            'menuContent': {
                templateUrl: 'templates/search.html'
            }
        }
    })
        .state('app.user-register', {
        url: '/user-register',
        views: {
            'menuContent': {
                templateUrl: 'templates/user-register.html',
                controller: 'UsrRegCtrl'
            }
        }
    })
        .state('app.pet-card', {
        url: '/pet-card',
        views: {
            'menuContent': {
                templateUrl: 'templates/pet-card.html'
            }
        }
    })
        .state('app.maps', {
        url: '/maps',
        views: {
            'menuContent': {
                templateUrl: 'templates/maps.html',
                controller: 'UsrRegCtrl'
            }
        }
    })
        .state('app.pet-register', {
        url: '/pet-register',
        views: {
            'menuContent': {
                templateUrl: 'templates/pet-register.html',
                controller: 'BrowseCtrl'
            }
        }
    })
        .state('app.pet-report', {
        url: '/pet-report',
        views: {
            'menuContent': {
                templateUrl: 'templates/pet-report.html',
                controller: 'PlaylistsCtrl'
            }
        }
    })
        .state('app.report-pet-lost', {
        url: '/report-pet-lost',
        views: {
            'menuContent': {
                templateUrl: 'templates/report-pet-lost.html',
                controller: 'RepPetLostCtrl'
            }
        }
    })
        .state('app.single', {
        url: '/pet-report/:playlistId',
        views: {
            'menuContent': {
                templateUrl: 'templates/playlist.html',
                controller: 'PlaylistCtrl'
            }
        }
    });
    // if none of the above states are matched, use this as the fallback
    $urlRouterProvider.otherwise('/app/pet-report');
});

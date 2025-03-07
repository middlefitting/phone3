
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PhoneLostPhoneManager from "./components/listers/PhoneLostPhoneCards"
import PhoneLostPhoneDetail from "./components/listers/PhoneLostPhoneDetail"
import PhonePhoneManager from "./components/listers/PhonePhoneCards"
import PhonePhoneDetail from "./components/listers/PhonePhoneDetail"

import LostservicePhoneChangeManager from "./components/listers/LostservicePhoneChangeCards"
import LostservicePhoneChangeDetail from "./components/listers/LostservicePhoneChangeDetail"

import GpsDestinationManager from "./components/listers/GpsDestinationCards"
import GpsDestinationDetail from "./components/listers/GpsDestinationDetail"


import GpsInfoView from "./components/GpsInfoView"
import GpsInfoViewDetail from "./components/GpsInfoViewDetail"
import PhoneView from "./components/PhoneView"
import PhoneViewDetail from "./components/PhoneViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/phones/lostPhones',
                name: 'PhoneLostPhoneManager',
                component: PhoneLostPhoneManager
            },
            {
                path: '/phones/lostPhones/:id',
                name: 'PhoneLostPhoneDetail',
                component: PhoneLostPhoneDetail
            },
            {
                path: '/phones/phones',
                name: 'PhonePhoneManager',
                component: PhonePhoneManager
            },
            {
                path: '/phones/phones/:id',
                name: 'PhonePhoneDetail',
                component: PhonePhoneDetail
            },

            {
                path: '/lostservices/phoneChanges',
                name: 'LostservicePhoneChangeManager',
                component: LostservicePhoneChangeManager
            },
            {
                path: '/lostservices/phoneChanges/:id',
                name: 'LostservicePhoneChangeDetail',
                component: LostservicePhoneChangeDetail
            },

            {
                path: '/gps/destinations',
                name: 'GpsDestinationManager',
                component: GpsDestinationManager
            },
            {
                path: '/gps/destinations/:id',
                name: 'GpsDestinationDetail',
                component: GpsDestinationDetail
            },


            {
                path: '/dashboards/gpsInfos',
                name: 'GpsInfoView',
                component: GpsInfoView
            },
            {
                path: '/dashboards/gpsInfos/:id',
                name: 'GpsInfoViewDetail',
                component: GpsInfoViewDetail
            },
            {
                path: '/dashboards/phones',
                name: 'PhoneView',
                component: PhoneView
            },
            {
                path: '/dashboards/phones/:id',
                name: 'PhoneViewDetail',
                component: PhoneViewDetail
            },


    ]
})

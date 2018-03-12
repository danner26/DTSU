'use strict';

import DynamicImport from 'app/components/DynamicImport';

const WebsiteRoutes = {
	childRoutes: [

		{
			path: '/',
			indexRoute: {
				getComponent(location, cb) {
					DynamicImport(
						import(/* webpackChunkName: "home" */'app/content/Home'),
						cb,
						'home'
					);
				}
			},
		},
		{
			path: 'about',
			indexRoute: {
				getComponent(location, cb) {
					DynamicImport(
						import(/* webpackChunkName: "about" */'app/content/About'),
						cb,
						'about'
					);
				}
			},
		},
		{
			path: 'services',
			indexRoute: {
				getComponent(location, cb) {
					DynamicImport(
						import(/* webpackChunkName: "services" */'app/content/Services'),
						cb,
						'services'
					);
				}
			},
		},
		{
			path: 'FAQ',
			indexRoute: {
				getComponent(location, cb) {
					DynamicImport(
						import(/* webpackChunkName: "faq" */'app/content/FAQ'),
						cb,
						'faq'
					);
				}
			},
		},
		{
			path: 'devteam',
			indexRoute: {
				getComponent(location, cb) {
					DynamicImport(
						import(/* webpackChunkName: "devteam" */'app/content/DevTeam'),
						cb,
						'devteam'
					);
				}
			},
		},
		{
			path: 'software',
			indexRoute: {
				getComponent(location, cb) {
					DynamicImport(
						import(/* webpackChunkName: "software" */'app/content/Software'),
						cb,
						'software'
					);
				}
			},
		},
		{
			path: 'support',
			indexRoute: {
				getComponent(location, cb) {
					DynamicImport(
						import(/* webpackChunkName: "support" */'app/content/Support'),
						cb,
						'support'
					);
				}
			},
		},
		{
			path: '*',
			getComponent(location, cb) {
				DynamicImport(
					import(/* webpackChunkName: "page-not-found" */'app/content/PageNotFound'),
					cb,
					'page-not-found'
				);
			}
		},

	],
};

export default WebsiteRoutes;

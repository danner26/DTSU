'use strict';

import React from 'react';
import { Route, IndexRoute } from 'react-router';

import Home from 'app/content/Home';
import About from 'app/content/About';
import Services from 'app/content/Services';
import FAQ from 'app/content/FAQ';
import DevTeam from 'app/content/DevTeam';
import Software from 'app/content/Software';
import Support from 'app/content/Support';
import PageNotFound from 'app/content/PageNotFound';


const routes = (
	<Route path='/'>
		<IndexRoute component={ Home } />
	    <Route path='about' component={ About } />
			<Route path='services' component={ Services } />
			<Route path='faq' component={ FAQ } />
			<Route path='devteam' component={ DevTeam } />
			<Route path='software' component={ Software } />
	    <Route path='support' component={ Support } />
		<Route path='*' component={ PageNotFound } />
	</Route>
);

export default routes;

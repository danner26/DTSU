'use strict';

import React from 'react';
import DefaultLayout from 'app/layouts/Default';
import { Heading } from 'app/components/UI';
import { Row, Col, Carousel } from 'antd';
import SEO from 'app/components/SEO';


const Home = (props) => {

	return (
		<DefaultLayout>

			<div className="component__empty">
				<Heading
					title="Home"
					subtitle="Under Construction."
				/>
			</div>

			<SEO url="home" />

		</DefaultLayout>
	);

}

export default Home;

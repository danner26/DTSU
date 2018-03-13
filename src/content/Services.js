'use strict';

import React from 'react';
import DefaultLayout from 'app/layouts/Default';
import { Heading, URL } from 'app/components/UI';
import { Row, Col } from 'antd';
import SEO from 'app/components/SEO';


const Services = (props) => {

	return (
		<DefaultLayout>

			<div className="component__empty">
				<Heading
					title="Services"
					subtitle="Under Construction."
				/>
			</div>

			<SEO url="services" />

		</DefaultLayout>
	);

}

export default Services;

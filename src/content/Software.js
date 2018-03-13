'use strict';

import React from 'react';
import DefaultLayout from 'app/layouts/Default';
import { Heading, URL } from 'app/components/UI';
import { Row, Col } from 'antd';
import SEO from 'app/components/SEO';


const Software = (props) => {

	return (
		<DefaultLayout>

			<div className="component__empty">
				<Heading
					title="Software"
					subtitle="Under Construction."
				/>
			</div>

			<SEO url="software" />

		</DefaultLayout>
	);

}

export default Software;

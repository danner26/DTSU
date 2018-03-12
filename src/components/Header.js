'use strict';

import React from 'react';
import { Link } from 'react-router';


const Header = (props) => {

	return (
		<header className="main">
		<div className="container">

			<div className="logo">
				<Link to="/">DTSU</Link>
			</div>

			<nav>
				<Link to="/" activeClassName="active">Home</Link>
				<span className="sep"></span>
				<Link to="/about" activeClassName="active">About</Link>
				<span className="sep"></span>
				<Link to="/services" activeClassName="active">Services</Link>
				<span className="sep"></span>
				<Link to="/faq" activeClassName="active">FAQ</Link>
				<span className="sep"></span>
				<Link to="/devteam" activeClassName="active">DevTeam</Link>
				<span className="sep"></span>
				<Link to="/software" activeClassName="active">Software</Link>
				<span className="sep"></span>
				<Link to="/support" activeClassName="active">Support</Link>
			</nav>

		</div>
		</header>
	);

}

export default Header;

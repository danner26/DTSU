<?php
	$user_id = $_GET['uid'];
	$lic = $_GET['lice'];
	$program_name = $_GET['pname'];
	$userLic = null;
	$subtract = 1;
	
	try {
		$db = new PDO('mysql:host=mysql15.citynetwork.se;dbname=123813-license-cue;charset=utf8', '123813-kg59703', 'dtsuread713');
	} catch(PDOException $e) {
		echo $e->getMessage();
	}
	
	$statement = $db->prepare('SELECT available FROM license WHERE id = :userid');
	$statement->execute(array(':userid' => $user_id));
	$avail = $statement->fetch();
	if ($program_name == 'cue137914') {
		if (substr(implode($avail), 1) > 0 && substr(implode($avail), 1) != null) {
			$state = $db->prepare('SELECT license FROM license WHERE id = :userid');
			$state->execute(array(':userid' => $user_id));
			$userLic = $state->fetch();
			if (substr(implode($userLic), 23) == $lic) {
				$newAvail = substr(implode($avail), 1) - 1;
				$help = $db->prepare('UPDATE license SET available=? WHERE id=?');
				$help->execute(array($newAvail, $user_id));
				echo '<p> true </p>';
			} else {
				echo '<p> false </p>';
			}
		} else {
			echo '<p> false </p>';
		}
	} else {
		'<p> false </p>';
	}
?>
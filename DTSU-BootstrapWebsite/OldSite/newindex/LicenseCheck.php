<?php 
	echo "This webpage works.";
	
	$user_id = $_GET['uid']; //get user id
	$lic = $_GET['lice']; //get licence
	
	
	
	echo $user_id . "<br />";
	echo $lic;
	
	try {
		$db = new PDO('mysql:host=mysql15.citynetwork.se;dbname=123913-license-cue;charset=utf8', '123813-kg59703', 'dtsuread713');
	} catch(PDOException $e) {
		echo $e->getMessage();
	}
	
	$statement = $db->prepare('SELECT available FROM license WHERE id = :userid');
	$statement->execute(array(':userid' => $user_id));
	$avail = $statement->fetch();
	echo $avail['available'];
	//$avail = mysql_query("SELECT available FROM license WHERE id = "user_id"");
	
	$db = null
	
?>
<?php
	session_start();

	function validEmail($email)
	{
	   $isValid = true;
	   $atIndex = strrpos($email, "@");
	   if (is_bool($atIndex) && !$atIndex)
	   {
		  $isValid = false;
	   }
	   else
	   {
		$domain = substr($email, $atIndex+1);
		  $local = substr($email, 0, $atIndex);
		  $localLen = strlen($local);
		  $domainLen = strlen($domain);
		  if ($localLen < 1 || $localLen > 64)
		  {
			 // local part length exceeded
			 $isValid = false;
		  }
		  else if ($domainLen < 1 || $domainLen > 255)
		  {
			 // domain part length exceeded
			 $isValid = false;
		  }
		  else if ($local[0] == '.' || $local[$localLen-1] == '.')
		  {
			 // local part starts or ends with '.'
			 $isValid = false;
		  }
		  else if (preg_match('/\\.\\./', $local))
		  {
			 // local part has two consecutive dots
			 $isValid = false;
		  }
		  else if (!preg_match('/^[A-Za-z0-9\\-\\.]+$/', $domain))
		  {
			 // character not valid in domain part
			 $isValid = false;
		  }
		  else if (preg_match('/\\.\\./', $domain))
		  {
			 // domain part has two consecutive dots
			 $isValid = false;
		  }
		  else if
	(!preg_match('/^(\\\\.|[A-Za-z0-9!#%&`_=\\/$\'*+?^{}|~.-])+$/',
					 str_replace("\\\\","",$local)))
		  {
			 // character not valid in local part unless 
			 // local part is quoted
			 if (!preg_match('/^"(\\\\"|[^"])+"$/',
				 str_replace("\\\\","",$local)))
			 {
				$isValid = false;
			 }
		  }
		  if ($isValid && !(checkdnsrr($domain,"MX") || checkdnsrr($domain,"A")))
		  {
			 // domain not found in DNS
			 $isValid = false;
		  }
	   }
	   return $isValid;
	}
		
	$user_name = $_REQUEST['userName'];
	$user_email = $_REQUEST['userEmail'];
	$subject = $_REQUEST['subject'];
	$user_review = $_REQUEST['userReview'];
	$user_rating = $_REQUEST['rating'];
	$goodCheck = $_REQUEST['goodCheck'];
	$badCheck = $_REQUEST['termsCheck'];
	
	$emailResult = validEmail($user_email);
	
	if(!$emailResult) {
		echo json_encode("invalid1");
		die();
	}
	if ($user_rating == 0) {
		echo json_encode("invalid9");
		die();
	}
	if ($badCheck == "false") {
		if ($goodCheck == "true") {
			$temp_name = str_replace(' ', '', $user_name);
			$temp_names = str_replace('-', '', $temp_name);
			if (!(preg_match('#[0-9]#', $user_name))) {
				if (ctype_alnum($temp_names)) {
						try {
							$db = new PDO('mysql:host=mysql11.citynetwork.se;dbname=132604-reviews;charset=utf8', '132604-da16164', 'dtsupro7312');
							$sql = "INSERT INTO Reviews (Name, Email, Type, Review, Stars)
							VALUES ('$user_name', '$user_email', '$subject', '$user_review', $user_rating)";
							if($db->exec($sql) == true) {
								echo json_encode("valid");
							} else {
								echo json_encode("error");
							}
						} catch(PDOException $e) {
							echo json_encode("invalid3");
						}
						$db = null;
						die();
				} else {
					echo json_encode("invalid4");
				}
			} else {
				echo json_encode("invalid5");
			}
		} else {
			echo json_encode("invalid6");
		}
	} else {
		echo json_encode("invalid7");
	}
?>
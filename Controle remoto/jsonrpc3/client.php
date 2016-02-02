<?php
require_once 'includes/jsonRPCClient.php';
$myExample = new jsonRPCClient('http://localhost/jsonrpc3/server.php');

try {
	
	echo $myExample->goTop();
	
} catch (Exception $e) {
	echo nl2br($e->getMessage()).'<br />'."\n";
}

?>

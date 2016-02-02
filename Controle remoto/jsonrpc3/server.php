<?php
require_once 'includes/jsonRPCServer.php';
require 'includes/example.php';
require 'includes/restrictedExample.php';

$myExample = new example();
jsonRPCServer::handle($myExample)
	or print 'no request';
?>

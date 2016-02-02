<?php
$fp = fopen('data.txt', 'w');
		fwrite($fp, "{op:'left'}");
		fclose($fp);


?>

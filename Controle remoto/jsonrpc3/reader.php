<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>


</head>
<body>
<div id="div">

</div>
<script type="text/javascript">
function load(){


$.get('data.txt', function(data) {
   var text = eval("("+data+")");
	if(text['op']!=undefined){
                                $('#div').text(text['op']);
                                
                                }
}, 'text');

	setTimeout("load()",1000);

}

load();

</script>

</body>
</html>


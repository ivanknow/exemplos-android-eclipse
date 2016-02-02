<?php

class example {
	
	public function goTop(){
			
			salvaNoArquivo("top");		
	
		return 1;	
	}

	public function goBottom(){

		try{
			salvaNoArquivo("bottom");		
		}
		catch(Exception $e){
			return 0;		
		}		
		return 1;	
	}

	public function goRight(){

		try{
			salvaNoArquivo("right");		
		}
		catch(Exception $e){
			return 0;		
		}		
		return 1;	
	}

	public function goLeft(){

		try{
			salvaNoArquivo("left");		
		}
		catch(Exception $e){
			return 0;		
		}		
		return 1;	
	}

	
}

 function salvaNoArquivo($op){
		$fp = fopen('data.txt', 'w');
		fwrite($fp, "{op:'$op'}");
		fclose($fp);
	}

?>

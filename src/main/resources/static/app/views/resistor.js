
var colors1=["black","brown","red","orange","yellow","green","blue","violet","grey","white"];
var colors2=["black","brown","red","orange","yellow","green","blue","violet","grey","white"];
var colors3=["#C0C0C0","#FFD700","black","brown","red","orange","yellow","green","blue","violet","grey","white"];
var color3acc=[0.01,0.1,1,10,100,1000,10000,100000,1000000,10000000,100000000,1000000000];
var colors4=["#C0C0C0","#FFD700","brown","red","green","blue","violet","grey"];
var color4acc=[10,5,1,2,0.5,0.25,0.1,0.05]
var countPos1=0;
var countPos2=0;
var countPos3=0;
var countPos4=0;
var strVal="";
//alert( 'Привет всем присутствующим!' );
//if count !=0 -> calculate **** -1->0
function changeColor1() {
	countPos1++;
	if (countPos1==10) {
		countPos1=0;
	}
	document.getElementsByName("color1")[0].style.background=colors1[countPos1];
	calculate();
}
function changeColor2() {
	countPos2++;
	if (countPos2==10) {
		countPos2=0;
	}
	document.getElementsByName("color2")[0].style.background=colors2[countPos2];
	calculate();
}
function changeColor3() {
	countPos3++;
	if (countPos3==12) {
		countPos3=0;
	}
	document.getElementsByName("color3")[0].style.background=colors3[countPos3];
	calculate();
}
function changeColor4() {
	countPos4++;
	if (countPos4==8) {
		countPos4=0;
	}
	document.getElementsByName("color4")[0].style.background=colors4[countPos4];
	calculate();
}
function calculate(){
	var valuesRes = ((countPos1*10)+countPos2)*color3acc[countPos3];
	strVal=valuesRes+" +/-"+color4acc[countPos4]+"% Om";
	document.getElementById("show11").innerHTML=strVal;
}
function reverseCalculate(){
	strVal="";
	document.getElementById("show11").innerHTML="";
	var val = document.getElementById("textValue");
	var base=val.value;
	var te = base;
	var iterator=0;
	if (te!=null) {
		while (te>=10) {
			iterator++;
			te/=10;
		}
		var number1=Math.floor(te);
		te=base;
		for(var i=0;i<iterator-1;i++){
			te/=10;
		}
		te=te-number1*10;
		var number2 =Math.floor(te);
		te=base/((number1*10)+number2);
		var ter=color3acc[0];
		var number3=0;
		for (var i = 0; i <color3acc.length; i++) {
			if(Math.abs(te-color3acc[i])<ter){
				ter=Math.abs(te-color3acc[i]);
				number3=i;
			}
		}
		var res = ((number1*10)+number2)*color3acc[number3];
		var f4 = res-base;
		var f41=f4/base;
		var number4=0;
		var ter2=color4acc[0];
		for (var i = 0; i < color4acc.length; i++) {
			if (Math.abs(f41-color3acc[i])<ter2) {
				ter2=Math.abs(f41-color3acc[i]);
				number4=i;
			}
		}
		document.getElementsByName("color1")[0].style.background=colors1[number1];
		document.getElementsByName("color2")[0].style.background=colors2[number2];
		document.getElementsByName("color3")[0].style.background=colors3[number3];
		document.getElementsByName("color4")[0].style.background=colors4[number4];

		var countPos1=number1;
		var countPos2=number2;
		var countPos3=number3;
		var countPos4=number4;
	}
}
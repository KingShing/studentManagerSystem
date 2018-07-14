

function look(obj) {
	//console.log(obj)
	var node = $(obj);
	var IdNode =node.parent().parent().children().first();
    //lineIdNode
	console.log(IdNode.text());

	//ajax
    $.ajax({
    url : "student.do?id="+IdNode.text(),
    type : "GET",
    dataType : "JSON",

    success : function(data){
    			loadImage(data);
    		}, 
    })

}




function update(obj) {
	console.log("enter update()..")
	
			$.ajax({
				url : "studentPrototype.do",
				type : "POST",
				dataType : "json",
				success:function(data){
					//data  {"id":0,"name":null,"address":null,"age":0,"sex":null,"image":null,"picture":null}
					//field ["id","name",...,"image","picture"]
					fields = Object.keys(data)
					//加载模态框
					 loadModal(fields,obj);
				},
				error:function(){
					alert("get StudentPrototype failed")	
				},
			})
	
	console.log("out update()..")
}

window.flag = -1;
function listAll(){
	window.flag *= -1;
	var trNode = $("#tableTr");
	 var tbNode = $("#tableTbody");
	if(window.flag >0){
			$.ajax({
				url : "students.do",
				type : "POST",
				dataType : "JSON",
				success :function(data){
					//加载表格
					 LoadTable(data);
				},
			}) 
	}else{
		trNode.empty();
		tbNode.empty();
	}
    	
    	
}



function remove(obj) {
		if(!confirm("请确认是否删除!"))return ;
		var node = $(obj);
		var IdNode =node.parent().parent().children().first();
        //lineIdNode
		console.log("IdNode.text() : "+IdNode.text());

		//ajax

        $.ajax({
	        url : "delStudent.do?id="+IdNode.text(),
	        type : "GET",
	      //  dataType : "text",
	        success : function(){
	        		IdNode.parent().remove();},
	        error: function(){
	        		alert("操作失败!")
	        	},})
}
    
    
$(document).ready(function(){
       //加载页面
    	//pageLoad();
})


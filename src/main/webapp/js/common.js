//function remove(obj) {
//	//console.log(obj)
//	var node = $(obj);
//	var IdNode =node.parent().parent().children().first();
//    //lineIdNode
//	console.log(IdNode.text());
//
//	//ajax
//    $.ajax({
//    url : "delStudent.do",
//    type : "POST",
//    dataType : "JSON",
//
//    success : LoadInfo(data),
//    })
//
//}

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
    //加载模态框
    loadModal(obj);
	console.log("out update()..")
}


function LoadInfo(info){
    	
    	//去掉图片路径的key-value
    	for(var i = 0;i<info.length;i++){
    		delete info[i]['picture']
    		delete info[i]['image']//路径
    	}
    	console.log(info)
		
		
        //tr 节点
        var trNode = $("#tableTr");

        console.log(trNode);
        
        //学生列表
        var stuList = info;
        
        //添加操作列
        for (var i = 0; i < stuList.length; i++) {
			stuList[i]['操作']= "<button class='btn-link none-margin-padding text-danger' onclick='update(this)'>修改</button>"
				+  "<button class='btn-link none-margin-padding bg-danger' onclick='remove(this) '>删除</button>"+ 
				"<button class='btn-link none-margin-padding btn-success' onclick='look(this) '>查看</button>"
        }

        //动态生成th
        if(stuList.length!=0){
            var trkeys =  Object.keys(stuList[0])
            for (var i = 0;i < trkeys.length;i++){
                trNode.append("<th class='info'>"+trkeys[i]+"</th>")
            }

            //动态生成tr td
            var tbodyNode = $("#tableTbody");
            //行
            for (var i = 0; i <stuList.length ; i++) {
				var tdValue =null;
                //列
                var ss = Object.values(stuList[i])
                for (var j = 0;j < trkeys.length;j++){
                  tdValue += "<td>"+ss[j]+"</td>"
                }
                if((i+1)%2==0){
                	tbodyNode.append("<tr class='has-error'>"+tdValue+"</tr>")
				}else{
                	tbodyNode.append("<tr class='warning'>"+tdValue+"</tr>")
				}
            }
        }
};

function pageLoad(){
    	//后台获取表格数据
    	$.ajax({
			url : "students.do",
			type : "POST",
			dataType : "JSON",
			success :function(data){
				 LoadInfo(data);
			},
		}) 
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
    	pageLoad();
})


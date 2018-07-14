function loadModal(fields,obj){
        	 //增强数组
			Array.prototype.remove = function(val) { 
				var index = this.indexOf(val); 
				if (index > -1) { 
					this.splice(index, 1); 
				} 
			};
			//获取input的name
			var trs = $("#tableTr").first().children();
			var titles = fields
			//去除不显示的属性(作为模态框的表头)
			titles.remove("image");
			titles.remove("picture");
            console.log("titles: "+titles)
			var formNode = $("#myPopForm")
			//获取当前修改行的id
            var node = $(obj);
            var IdNode =node.parent().parent().children().first();
            var vid = IdNode.text();
			//动态创建表单
			formNode.empty();
            for (var i = 0; i < titles.length ; i++) {
                var t = titles[i];
                var content
                if(t=='id'){
                	content = "<div class='form-group'><label>"+t+"</label><input readonly type='text' class='form-control' value='"+vid+"' name='"+t+"' id='"+t+"'/> </div>"
                }else{
                	 content ="<div class='form-group'><label>"+t+"</label><input type='text' class='form-control' name='"+t+"' id='"+t+"'/> </div>"
                }
				console.log("titles["+i+"]"+t)
                formNode.append(content)
            }
            var fileNode = "<div class='form-group'><label >头像</label> <input type='file' name='picture' id='stuPicture' /> <p class='help-block'>请上传头像</p></div>"
			
            //
			
			formNode.append(fileNode);

         

			 $('#myModal').modal({ })
            /**
             *  第一是 .modal，用来把 <div> 的内容识别为模态框。
             第二是 .fade class。当模态框被切换时，它会引起内容淡入淡出。
             aria-labelledby="myModalLabel"，该属性引用模态框的标题。
             属性 aria-hidden="true" 用于保持模态窗口不可见，直到触发器被触发为止（比如点击在相关的按钮上）。
             <div class="modal-header">，modal-header 是为模态窗口的头部定义样式的类。
             class="close"，close 是一个 CSS class，用于为模态窗口的关闭按钮设置样式。
             data-dismiss="modal"，是一个自定义的 HTML5 data 属性。在这里它被用于关闭模态窗口。
             class="modal-body"，是 Bootstrap CSS 的一个 CSS class，用于为模态窗口的主体设置样式。
             class="modal-footer"，是 Bootstrap CSS 的一个 CSS class，用于为模态窗口的底部设置样式。
             data-toggle="modal"，HTML5 自定义的 data 属性 data-toggle 用于打开模态窗口。
             */
			
          
 }
function loadImage(obj){
	/*
	 * obj //json对象
	 * {"id":1,"name":"叶金成","address":"武汉","age":23,"sex":"男","image":"/images/4a4904d96c9a41f4a148cafc1003d532.jpeg","picture":null}
	 * 
	 * 
	 * */
	//["id", "name", "address", "age", "sex", "image", "picture"]
	var  keys = Object.keys(obj);
	
	//去掉picture	
	keys.pop();
	
	//[1, "叶金成", "武汉", 23, "男", "/images/4a4904d96c9a41f4a148cafc1003d532.jpeg", null]
	var values = Object.values(obj);
	
	//去掉null
	values.pop();	

	console.log("enter loadImage(obj) ...")


	var formNode = $("#myPopForm2")
	var leftNode = $("#leftImage") 
	//动态创建表单
	formNode.empty();
	leftNode.empty();
	//keys.length-2://除了image
    for (var i = keys.length-2;i >=0 ; i--) {
        var k = keys[i];
        var v = values[i];
		var content ="<div class='form-group'><label>"+k+"</label><input readonly type='text' class='form-control' value='"+v+"' /> </div>"
		//console.log(content)
        formNode.prepend(content)
    }

    var imageSrc = "Http://127.0.0.1:8080"+values[values.length-1];

    var imageNode = "<img  src='"+imageSrc+"' class='img-thumbnail img-responsive img-circle  '></img>";
    //
    leftNode.append(imageNode);

	 $('#myModal2').modal({ })
  
}


//

function loadAddModal(fields){
	 //增强数组
	Array.prototype.remove = function(val) { 
		var index = this.indexOf(val); 
		if (index > -1) { 
			this.splice(index, 1); 
		} 
	};
	//获取input的name
	var trs = $("#tableTr").first().children();
	var titles = fields
	//去除不显示的属性(作为模态框的表头)
	titles.remove("image");
	titles.remove("picture");
    console.log("titles: "+titles)
	var formNode = $("#myAddForm")

	//动态创建表单
	formNode.empty();
    for (var i = 0; i < titles.length ; i++) {
        var t = titles[i];
        var content
        if(t=='id'){
        	content = "<input  type='hidden' class='form-control'  id='"+t+"'/> </div>"
        }else{
        	 content ="<div class='form-group'><label>"+t+"</label><input type='text' class='form-control' name='"+t+"' id='"+t+"'/> </div>"
        }
		console.log("titles["+i+"]"+t)
        formNode.append(content)
    }
    var fileNode = "<div class='form-group'><label >头像</label> <input type='file' name='picture' id='stuPicture' /> <p class='help-block'>请上传头像</p></div>"
	
    //
	
	formNode.append(fileNode);

 

	 $('#myModal3').modal({ })
}
//onclick触发
function summitForm() {			
            var formNode = $("#myPopForm")
              //update提交表单
			formNode.submit()
}

function summitAddForm() {			
    var formNode = $("#myAddForm")
      //add提交表单
	formNode.submit()
}


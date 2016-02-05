 function myfun(){
           $("#btn3").click();
     }
     window.onload=myfun;
     
     $(function(){
       var page=0;
        
       //上一页
       $("#btn1").click(function(){
           page=page-1;
           if(page<=0){
             page=page+1;
             alert("已经是第一页了！");
             return;
           }
           $("#tbody1").html("");
           $.ajax({
             url:"dataChangeSystemParamRecordIndex.do",
             type:"post",
             data:{"page":page,"user_id":$("#user_id").val()},
             dataType:"json",
             success:function(data){
               var str="";
               if(data.list.length==0){
            	 
  	               $("#tbody1").append(str);
  	               $("#btn2").html("第"+data.page);
  	               $("#span").html(data.totalCount);
  	               return;
  	            }
              
               for(var i=0;i<data.list.length;i++){
                 str+="<tr><td>"+data.list[i].old_user_scale+"&nbsp;%</td><td>"+
                 data.list[i].new_user_scale+"&nbsp;%</td><td>"+data.list[i].old_recommend_scale+
                 "&nbsp;%</td><td>"+data.list[i].new_recommend_scale+"&nbsp;%</td><td>"+data.list[i].old_commission_quota+
                 "&nbsp;%</td><td>"+data.list[i].new_commission_quota+"&nbsp;%</td><td>"+data.list[i].add_time+"</td><td>"+
                 data.list[i].auditer_name+"</td></tr>";
               }
               $("#tbody1").append(str);
               $("#btn2").html("第"+data.page);
               $("#span").html(data.totalCount);
             
             },
             error:function(){alert("查询出错了！");}
           });
       });
       
       
       //下一页
        $("#btn3").click(function(){
           page=page+1;
           if(page>$("#span").html()){
             page=page-1;
             alert("已经是最后一页了！");
             return;
           }
          
           $("#tbody1").html("");
           $.ajax({
             url:"dataChangeSystemParamRecordIndex.do",
             type:"post",
             data:{"page":page,"user_id":$("#user_id").val()},
             dataType:"json",
             success:function(data){
                var str="";
            	if(data.list.length==0){
            		
  	               $("#tbody1").append(str);
  	               $("#btn2").html("第"+data.page);
  	               $("#span").html(data.totalCount);
  	               return;
  	            }
              
               for(var i=0;i<data.list.length;i++){
                 str+="<tr><td>"+data.list[i].old_user_scale+"&nbsp;%</td><td>"+
                 data.list[i].new_user_scale+"&nbsp;%</td><td>"+data.list[i].old_recommend_scale+
                 "&nbsp;%</td><td>"+data.list[i].new_recommend_scale+"&nbsp;%</td><td>"+data.list[i].old_commission_quota+
                 "&nbsp;%</td><td>"+data.list[i].new_commission_quota+"&nbsp;%</td><td>"+data.list[i].add_time+"</td><td>"+
                 data.list[i].auditer_name+"</td></tr>";
               }
               $("#tbody1").append(str);
               $("#btn2").html("第"+data.page);
               $("#span").html(data.totalCount); 
             },
             error:function(){alert("查询出错了！");}
           });
       });
       
     
        $("#btn4").click(function(){
        	window.location.href="toSystemParamIndex.do";
        });
     });
     
     

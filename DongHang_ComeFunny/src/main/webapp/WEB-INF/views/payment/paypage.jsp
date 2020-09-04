<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<%@ page import="com.DongHang_ComeFunny.www.model.vo.User" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/mypage/mypage_header.css" />
<script type="text/javascript">

	$(document).ready(function() {
		<%
		   User user = (User) session.getAttribute("logInInfo");
		%>
		$('#b1, #b2, #b3, #b4, #b5, #b6').click(function() {
			  var price = $(this).val();
			  var IMP = window.IMP; // 생략가능
				IMP.init('imp91024361');
				IMP.request_pay({
				    pg : 'inicis', // version 1.1.0부터 지원.
				    pay_method : 'card',
				    merchant_uid : '<%=user.getUserId()%>'+'_' + new Date().getTime(),
				    name : '동행복권 '+price/100+'개',
				    amount : price,
				    buyer_name : '<%=user.getuName()%>',
				    buyer_tel : '<%=user.getuPhone()%>',
				}, function(rsp) {
				    if ( rsp.success ) {
				        var msg = '결제가 완료되었습니다.';
				        msg += '고유ID : ' + rsp.imp_uid;
				        msg += '상점 거래ID : ' + rsp.merchant_uid;
				        msg += '결제 금액 : ' + rsp.paid_amount;
				        msg += '카드 승인번호 : ' + rsp.apply_num;
				        console.log(msg)				       
				   	 $.ajax({
			             type: "get",
			             url: "/payment/commitpay?impuid="+rsp.imp_uid+"&merchantuid="+rsp.merchant_uid+"&paidamount="+rsp.paid_amount+
			             "&userno="+'<%=user.getuNo()%>'+"&count="+(rsp.paid_amount/100	)+"&date="+rsp.paid_at,			            			            		
			             async: false,     //값을 리턴시 해당코드를 추가하여 동기로 변경
			             dataType:"JSON",
			             success: function (data) {
			            	 console.log("abba")
			             }
			         });
				    } else {
				        var msg = '결제에 실패하였습니다.';
				        msg += '에러내용 : ' + rsp.error_msg;
				        alert(msg);
				    }
				    
		})
		
		});
	})
</script>

   <div>
      <div>
         <div style=" width: 200px; height: 70px;">
         <img style=" width: 200px; height: 70px; class="logo-img" alt="로고이미지" src="/resources/image/header/logo.png" >
         </div>
      </div>
   </div>
		<div style="width:700px; height:120px;border:1px solid black; margin 50px;">
								<ul style=" list-style:none; float:left">
								<li>
									<dl>
										<dt><span>동행복권 1장</span><button  style="margin-left:100px;width:60px" id="b1" value="100">100원</button></dt>
									</dl>
								</li>								
								<li>
									<dl>
										<dt><span>동행복권 5장</span><button style="margin-left:100px;width:60px" id="b2" value="500">500원</button></dt>
									</dl>
								</li>
								<li>
									<dl>
										<dt><span>동행복권 10장</span><button style="margin-left:91px;width:60px" id="b3" value="1000">1,000원</button></dt>
									</dl>
								</li>
								</ul>
								<ul style=" list-style:none;">
								<li>
									<dl>
										<dt><span>동행복권 30장</span><button  style="margin-left:90px;width:60px"id="b4" value="3000">3,000원</button></dt>										
									</dl>
								</li>
								
								<li>
									<dl>
										<dt><span>동행복권 50장</span><button style="margin-left:90px;width:60px" id="b5" value="5000">5,000원</button></dt>
									</dl>
								</li>
								<li>
									<dl>
										<dt><span>동행복권 100장</span><button style="margin-left:81px;width:60px" id="b6" value="10000">10,000원</button></dt>
									</dl>
								</li>
								</ul>
</div>
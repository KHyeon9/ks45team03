var idJ = /^[a-z0-9]{5,12}$/;
var pwJ = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
var nameJ = /^[A-Za-z가-힣]{2,20}$/;
var nicknameJ = /^[A-Za-z가-힣0-9]{2,10}$/;
var mailIdJ = /^[0-9a-z]{2,20}$/;
var mailAddrJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
var phoneJ = /^[0-9]{4,4}?[0-9]{4,4}$/;
var addrJ = /^[가-힣0-9 ,-@.~_]{2,30}$/

$('#regionSidoCode').change(function(){
			
	var project = $('#regionSidoCode').val();	
	
	$.ajax({
			type: 'POST',
			url: '/addUser/ajaxProject',
			data: { project },
			success: function(result){
				
				var sggOption = {};
				var blankOption = '<option></option>';
				var defaultOption = '<option>등록된 지역이 없습니다.</option>';
				
				for (var i = 0; i < result.length; i++) {
				 sggOption += '<option value="' + result[i].regionSggCode + '">' + result[i].regionSggName + '</option>';	    			
				}
				
				if(result == '' || result == 'undefined') {
					 $('#regionSggCode').html(defaultOption);
				}else{
					 $('#regionSggCode').html(blankOption);
					 $('#regionSggCode').append(sggOption);
				}
			},
			error: function(project) {
				alert("error");
			}
		})
});

$('#selectEmail').change(function(){
	var selectEmail = $('#selectEmail').val();
	if(selectEmail == '직접입력'){
		$('#userEmailAddr').val('');
		$('#userEmailAddr').focus();
	}else{
		$('#userEmailAddr').val(selectEmail);
		$('#userEmailAddr').focus();
	}
});
	
$(function(){
	function validateValue(checkValue){
		if(typeof checkValue == 'undefined'
				|| checkValue == null
				|| checkValue == '' ){
			return true;
		}
		return false;
	}
		
	$("#userId").blur(function() {
		
		var userId = $('#userId').val();
		
		if(validateValue($(this).val())) {
			$('#userIdCheck').html('필수정보입니다.');
			$(this).removeClass('is-valid');
			$(this).addClass('is-invalid');
			return false;
		}else{
			$('#userIdCheck').html('');
			$(this).removeClass('is-invalid');
			$(this).addClass('is-valid');
		}
		
		if(!idJ.test($(this).val())){
			$('#userIdCheck').html('5~12자의 영문 소문자, 숫자만 사용 가능합니다.');
			$(this).removeClass('is-valid');
			$(this).addClass('is-invalid');
			return false;	
		}else{
			$('#userIdCheck').html('');
			$(this).removeClass('is-invalid');
			$(this).addClass('is-valid');
		}
		
		
		$.ajax({
			url : '/addUser/idCheck',
			type : 'GET',
			data: { userId },
			success: function(idCheck) {
				if(idCheck){
					$('#userIdCheck').html('중복된 아이디입니다.');
					$('#userId').removeClass('is-valid');
					$('#userId').addClass('is-invalid');
				}else{
					$('#userIdCheck').html('');
					$('#userId').removeClass('is-invalid');
					$('#userId').addClass('is-valid');
				}
				
			},
			error: function(jqXHR, textStatus){
				console.log( 'Request failed: ' + textStatus );
			}
		});
	});
				
	$('#userPw').blur(function() {
		
		if(validateValue($(this).val())) {
			$('#userPwCheck').html('필수정보입니다.');
			$(this).removeClass('is-valid');
			$(this).addClass('is-invalid');
			return false;
		}
		
		if(!pwJ.test($(this).val())){
			$('#userPwCheck').html('8~15자 영문 대 소문자, 숫자, 특수문자를 사용하세요.');
			$(this).removeClass('is-valid');
			$(this).addClass('is-invalid');
			return false;	
		}
			
		$('#userPwCheck').html('');
		$(this).removeClass('is-invalid');
		$(this).addClass('is-valid');
	});
	
	$('#userPwConfirm').blur(function() {
		
		if(validateValue($(this).val())) {
			$('#userPwConfirmCheck').html('필수정보입니다.');
			$(this).removeClass('is-valid');
			$(this).addClass('is-invalid');
			return false;
		}
		
		if($(this).val() != $('#userPw').val()) {
			$('#userPwConfirmCheck').html('비밀번호가 일치하지 않습니다.');
			$(this).removeClass('is-valid');
			$(this).addClass('is-invalid');
			return false;	
		}
			
		$('#userPwConfirmCheck').html('');
		$(this).removeClass('is-invalid');
		$(this).addClass('is-valid');
	});
	
	$('#userName').blur(function() {
		
		if(validateValue($(this).val())) {
			$('#userNameCheck').html('필수정보입니다.');
			$(this).removeClass('is-valid');
			$(this).addClass('is-invalid');
			return false;
		}
		
		if(!nameJ.test($(this).val())){
			$('#userNameCheck').html('한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)');
			$(this).removeClass('is-valid');
			$(this).addClass('is-invalid');
			return false;	
		}
		
		$('#userNameCheck').html('');
		$(this).removeClass('is-invalid');
		$(this).addClass('is-valid');
	});
	
	$('#userNickName').blur(function(){
		
		var userNickName = $('#userNickName').val();
		
		if(validateValue($(this).val())) {
			$('#userNickNameCheck').html('필수정보입니다.');
			$(this).removeClass('is-valid');
			$(this).addClass('is-invalid');
			return false;
		}else{
			$('#userNickNameCheck').html('');
			$(this).removeClass('is-invalid');
			$(this).addClass('is-valid');
		}
		
		if(!nicknameJ.test($(this).val())){
			$('#userNickNameCheck').html('띄어쓰기 없이 한글, 영문, 숫자 2-10자');
			$(this).removeClass('is-valid');
			$(this).addClass('is-invalid');
			return false;	
		}else{
			$('#userNickNameCheck').html('');
			$(this).removeClass('is-invalid');
			$(this).addClass('is-valid');
		}
		
		$.ajax({
			url : '/addUser/nickNameCheck',
			type : 'GET',
			data: { userNickName },
			success: function(nickNameCheck) {
				
				if(nickNameCheck){
					$('#userNickNameCheck').html('중복된 아이디입니다.');
					$('#userNickName').removeClass('is-valid');
					$('#userNickName').addClass('is-invalid');
				}else{
					$('#userIdCheck').html('');
					$('#userNickName').removeClass('is-invalid');
					$('#userNickName').addClass('is-valid');
				}
			},
			error: function(jqXHR, textStatus){
				console.log( 'Request failed: ' + textStatus );
			}
		});
		
		$(this).removeClass('is-invalid');
		$(this).removeClass('is-valid');
	});
	
	$('#userEmailId').blur(function() {
		
		if(validateValue($(this).val())) {
			$('#userEmailCheck').html('필수정보입니다.');
			$(this).removeClass('is-valid');
			$(this).addClass('is-invalid');
			return false;
		}
		
		if(!mailIdJ.test($(this).val())){
			$('#userEmailCheck').html('이메일을 다시 확인해주세요.');
			$(this).removeClass('is-valid');
			$(this).addClass('is-invalid');
			return false;	
		}
		
		$('#userEmailCheck').html('');
		$(this).removeClass('is-invalid');
		$(this).addClass('is-valid');
	});
	
		$('#userEmailAddr').blur(function() {
		
		if(validateValue($(this).val())) {
			$('#userEmailCheck2').html('필수정보입니다.');
			$(this).removeClass('is-valid');
			$(this).addClass('is-invalid');
			return false;
		}
		
		if(!mailAddrJ.test($(this).val())){
			$('#userEmailCheck2').html('이메일을 다시 확인해주세요.');
			$(this).removeClass('is-valid');
			$(this).addClass('is-invalid');
			return false;	
		}
		
		$('#userEmailCheck2').html('');
		$(this).removeClass('is-invalid');
		$(this).addClass('is-valid');
	});
	
	$('#userPhoneNumber').blur(function(){
		
		if(validateValue($(this).val())) {
			$('#userPhoneNumberCheck').html('필수정보입니다.');
			$(this).removeClass('is-valid');
			$(this).addClass('is-invalid');
			return false;
		}
	
		if(!phoneJ.test($(this).val())){
			$('#userPhoneNumberCheck').html('형식에 맞지 않는 번호입니다.');
			$(this).removeClass('is-valid');
			$(this).addClass('is-invalid');
			return false;	
		}
		
		$('#userPhoneNumberCheck').html('');
		$(this).removeClass('is-invalid');
		$(this).addClass('is-valid');
	});
	
	$('#regionSidoCode').change(function(){
		
		if($(this).val() == '시ㆍ도를 선택해주세요.'){
			$('#regionSidoCodeCheck').html('필수정보입니다.');
			$('#regionSggCodeCheck').html('필수정보입니다.');
			$(this).removeClass('is-valid');
			$(this).addClass('is-invalid');
			$('#regionSggCode').removeClass('is-valid');
			$('#regionSggCode').addClass('is-invalid');
			return false;
		}
		
		$('#regionSidoCodeCheck').html('');
		$(this).removeClass('is-invalid');
		$(this).addClass('is-valid');
	});
	
	$('#regionSggCode').change(function(){
		
		if($(this).val() == ''){
			$('#regionSggCodeCheck').html('필수정보입니다.');
			$(this).removeClass('is-valid');
			$(this).addClass('is-invalid');
			return false;
		}
		
		$('#regionSggCodeCheck').html('');
		$(this).removeClass('is-invalid');
		$(this).addClass('is-valid');
	});
	
	$('#userAddrDesc').blur(function(){
		
		if(validateValue($(this).val())) {
			$('#userAddrDescCheck').html('필수정보입니다.');
			$(this).removeClass('is-valid');
			$(this).addClass('is-invalid');
			return false;
		}
	
		if(!addrJ.test($(this).val())){
			$('#userAddrDescCheck').html('올바른 상세주소를 적어주세요.');
			$(this).removeClass('is-valid');
			$(this).addClass('is-invalid');
			return false;	
		}
		
		$('#userAddrDescCheck').html('');
		$(this).removeClass('is-invalid');
		$(this).addClass('is-valid');
	});
});




$(function(){
		function validateValue(checkValue){
			if(typeof checkValue == 'undefined'
					|| checkValue == null
					|| checkValue == '' ){
				return true;
			}
			return false;
		}
		
	$("#submitBtn").click(function() {
		
		var userId = $('#userId').val();
		if(validateValue(userId)) {
			$('#userIdCheck').html('필수정보입니다.');
			$('#userId').removeClass('is-valid');
			$('#userId').addClass('is-invalid');
			$('#userId').focus();
			return false;
		}
		
		if(!idJ.test(userId)){
			$('#userIdCheck').html('5~12자의 영문 소문자, 숫자만 사용 가능합니다.');
			$('#userId').removeClass('is-valid');
			$('#userId').addClass('is-invalid');
			$('#userId').focus();
			return false;	
		}
		
		$.ajax({
			url : '/addUser/idCheck',
			type : 'GET',
			data: { userId },
			success: function(idCheck) {
				if(idCheck){
					$('#userIdCheck').html('중복된 아이디입니다.');
					$('#userId').removeClass('is-valid');
					$('#userId').addClass('is-invalid');
					$('#userId').focus();
					return false
				}
			},
			error: function(jqXHR, textStatus){
				console.log( 'Request failed: ' + textStatus );
			}
		});
		
		var userPw = $('#userPw').val();		
		if(validateValue(userPw)) {
			$('#userPwCheck').html('필수정보입니다.');
			$('#userPw').removeClass('is-valid');
			$('#userPw').addClass('is-invalid');
			$('#userPw').focus();
			return false;
		}
		
		if(!pwJ.test(userPw)){
			$('#userPwCheck').html('8~15자 영문 대 소문자, 숫자, 특수문자를 사용하세요.');
			$('#userPw').removeClass('is-valid');
			$('#userPw').addClass('is-invalid');
			$('#userPw').focus();
			return false;	
		}
	
		var userPwConfirm = $('#userPwConfirm').val();
		if(validateValue(userPwConfirm)) {
			$('#userPwConfirmCheck').html('필수정보입니다.');
			$('#userPwConfirm').removeClass('is-valid');
			$('#userPwConfirm').addClass('is-invalid');
			$('#userPwConfirm').focus();
			return false;
		}
		
		if(userPwConfirm != userPw) {
			$('#userPwConfirmCheck').html('비밀번호가 일치하지 않습니다.');
			$('#userPwConfirm').removeClass('is-valid');
			$('#userPwConfirm').addClass('is-invalid');
			$('#userPwConfirm').focus();
			return false;	
		}
		
		var userName = $('#userName').val();
		if(validateValue(userName)) {
			$('#userNameCheck').html('필수정보입니다.');
			$('#userName').removeClass('is-valid');
			$('#userName').addClass('is-invalid');
			$('#userName').focus();
			return false;
		}
		
		if(!nameJ.test(userName)){
			$('#userNameCheck').html('한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)');
			$('#userName').removeClass('is-valid');
			$('#userName').addClass('is-invalid');
			$('#userName').focus();
			return false;	
		}
		
		var userNickName = $('#userNickName').val();
		if(validateValue(userNickName)) {
			$('#userNickNameCheck').html('필수정보입니다.');
			$('#userNickName').removeClass('is-valid');
			$('#userNickName').addClass('is-invalid');
			$('#userNickName').focus();
			return false;
		}
		
		if(!nicknameJ.test(userNickName)){
			$('#userNickNameCheck').html('띄어쓰기 없이 한글, 영문, 숫자 2-10자');
			$('#userNickName').removeClass('is-valid');
			$('#userNickName').addClass('is-invalid');
			$('#userNickName').focus();
			return false;	
		}
		
		$.ajax({
			url : '/addUser/nickNameCheck',
			type : 'GET',
			data: { userNickName },
			success: function(nickNameCheck) {
				
				if(nickNameCheck){
					$('#userNickNameCheck').html('중복된 아이디입니다.');
					$('#userNickName').removeClass('is-valid');
					$('#userNickName').addClass('is-invalid');
					$('#userNickName').focus();
				}
			},
			error: function(jqXHR, textStatus){
				console.log( 'Request failed: ' + textStatus );
			}
		});
		
		var userEmailId = $('#userEmailId').val();
		
		if(validateValue(userEmailId)) {
			$('#userEmailCheck').html('필수정보입니다.');
			$('#userEmailId').removeClass('is-valid');
			$('#userEmailId').addClass('is-invalid');
			return false;
		}
		
		if(!mailIdJ.test(userEmailId)){
			$('#userEmailCheck').html('이메일을 다시 확인해주세요.');
			$(this).removeClass('is-valid');
			$(this).addClass('is-invalid');
			return false;	
		}
		
	
		var userEmailAddr = $('#userEmailAddr').val();	
		
		if(validateValue(userEmailAddr)) {
			$('#userEmailCheck2').html('필수정보입니다.');
			 $('#userEmailAddr').removeClass('is-valid');
			 $('#userEmailAddr').addClass('is-invalid');
			return false;
		}
		
		if(!mailAddrJ.test(userEmailAddr)){
			$('#userEmailCheck2').html('이메일을 다시 확인해주세요.');
			$('#userEmailAddr').removeClass('is-valid');
			$('#userEmailAddr').addClass('is-invalid');
			return false;	
		}
		
		var userPhoneNumber = $('#userPhoneNumber').val();
		if(validateValue(userPhoneNumber)) {
			$('#userPhoneNumberCheck').html('필수정보입니다.');
			$('#userPhoneNumber').removeClass('is-valid');
			$('#userPhoneNumber').addClass('is-invalid');
			$('#userPhoneNumber').focus();
			return false;
		}
	
		if(!phoneJ.test(userPhoneNumber)){
			$('#userPhoneNumberCheck').html('형식에 맞지 않는 번호입니다.');
			$('#userPhoneNumber').removeClass('is-valid');
			$('#userPhoneNumber').addClass('is-invalid');
			$('#userPhoneNumber').focus();
			return false;	
		}
	
		var regionSidoCode = $('#regionSidoCode').val();
		if(regionSidoCode == '시ㆍ도를 선택해주세요.' || regionSidoCode == '' ||  regionSidoCode == 'undefined' ||  regionSidoCode == null){
			$('#regionSidoCodeCheck').html('필수정보입니다.');
			$('#regionSidoCode').removeClass('is-valid');
			$('#regionSidoCode').addClass('is-invalid');
			$('#regionSidoCode').focus();
			return false;
		}
		
		var regionSggCode = $('#regionSggCode').val();
		if(regionSggCode == ''){
			$('#regionSggCodeCheck').html('필수정보입니다.');
			$('#regionSggCode').removeClass('is-valid');
			$('#regionSggCode').addClass('is-invalid');
			$('#regionSggCode').focus();
			return false;
		}
		
		var userAddrDesc = $('#userAddrDesc').val();
		if(validateValue(userAddrDesc)) {
			$('#userAddrDescCheck').html('필수정보입니다.');
			$('#userAddrDesc').removeClass('is-valid');
			$('#userAddrDesc').addClass('is-invalid');
			$('#userAddrDesc').focus();
			return false;
		}
	
		if(!addrJ.test(userAddrDesc)){
			$('#userAddrDescCheck').html('올바른 상세주소를 적어주세요.');
			$('#userAddrDesc').removeClass('is-valid');
			$('#userAddrDesc').addClass('is-invalid');
			$('#userAddrDesc').focus();
			return false;	
		}
		
		userPhoneNumber = $('firstPhoneNumber').val() + userPhoneNumber;
		$('#userEmail').val(userEmailId + '@' + userEmailAddr);
		$('#addForm').submit();
		
		});
		
});
		
		
		
				
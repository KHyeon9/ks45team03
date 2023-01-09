$('#account').hide();   // 초깃값 설정

$("input[name='payment.paymentType']").change(function(){
		
	if($("input[name='payment.paymentType']:checked").val() == '카드'){
		$('#account').hide();
		$('#card').show();
		$('#cardAgency').attr('disabled', false);
		$('#cardNumber').attr('disabled', false);
		$('#accountAgency').attr('disabled', true);
		$('#accountNumber').attr('disabled', true);
	}
	// 신용카드 결제 선택 시.
	else if($("input[name='payment.paymentType']:checked").val() == '통장'){
		$('#card').hide();
		$('#account').show();
		$('#accountAgency').attr('disabled', false);
		$('#accountNumber').attr('disabled', false);
		$('#cardAgency').attr('disabled', true);
		$('#cardNumber').attr('disabled', true);
	}
});

$('#regionSidoCode').change(function(){
			
	var project = $('#regionSidoCode').val();
	
	$.ajax({
			type: 'POST',
			url: '/addUser/ajaxProject',
			data: { project },
			success: function(result){
				
				var sggOption = {};
				var blankOption = '<option>시ㆍ군ㆍ구를 선택해주세요.</option>';
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
	
$(function(){
	function validateValue(checkValue){
		if(typeof checkValue == 'undefined'
				|| checkValue == null
				|| checkValue == '' ){
			return true;
		}
		return false;
	}
	
	
	
	if($("input[name='payment.paymentType']:checked").val() == '카드'){
		$('#cardNumber').blur(function(){
		
			if(validateValue($(this).val())) {
				$('#cardNumber').html('필수정보입니다.');
				$(this).addClass('is-invalid');
				return false;
			}
		
			$('#cardNumber').html('');
			$(this).removeClass('is-invalid');
		});
	}
	else if($("input[name='payment.paymentType']:checked").val() == '통장'){
		$('#accountNumber').blur(function(){
		
			if(validateValue($(this).val())) {
				$('#accountNumber').html('필수정보입니다.');
				$(this).addClass('is-invalid');
				return false;
			}
		
			$('#accountNumber').html('');
			$(this).removeClass('is-invalid');
		});
	}
	
	
	$('#rentalStartDate').blur(function(){
		
		if(validateValue($(this).val())) {
			$('#rentalStartDate').html('필수정보입니다.');
			$(this).addClass('is-invalid');
			return false;
		}
		
		$('#rentalStartDate').html('');
		$(this).removeClass('is-invalid');
	});
	
	$('#rentalEndDate').blur(function(){
		
		if(validateValue($(this).val())) {
			$('#rentalEndDate').html('필수정보입니다.');
			$(this).addClass('is-invalid');
			return false;
		}
		
		$('#rentalEndDate').html('');
		$(this).removeClass('is-invalid');
	});
	
	$('#mileageUse').blur(function(){
		
		if(validateValue($(this).val())) {
			$('#mileageUse').html('필수정보입니다.');
			$(this).addClass('is-invalid');
			return false;
		}
		
		$('#mileageUse').html('');
		$(this).removeClass('is-invalid');
	});

	$('#regionSidoCode').change(function(){
		
		if($(this).val() == '시ㆍ도를 선택해주세요.'){
			$('#regionSidoCodeCheck').html('필수정보입니다.');
			$('#regionSggCodeCheck').html('필수정보입니다.');
			$(this).addClass('selectInvalid');
			$('#regionSggCode').addClass('selectInvalid');
			return false;
		}
		
		$('#regionSidoCodeCheck').html('');
		$(this).removeClass('selectInvalid');
	});
	
	$('#regionSggCode').change(function(){
		
		if($(this).val() == ''){
			$('#regionSggCodeCheck').html('필수정보입니다.');
			$(this).addClass('selectInvalid');
			return false;
		}
		
		$('#regionSggCodeCheck').html('');
		$(this).removeClass('selectInvalid');
	});
	
	$('#userAddrDesc').blur(function(){
		
		if(validateValue($(this).val())) {
			$('#userAddrDescCheck').html('필수정보입니다.');
			$(this).addClass('is-invalid');
			return false;
		}
	
		if(!addrJ.test($(this).val())){
			$('#userAddrDescCheck').html('올바른 상세주소를 적어주세요.');
			$(this).addClass('is-invalid');
			return false;	
		}
		
		$('#userAddrDescCheck').html('');
		$(this).removeClass('is-invalid');
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
		
		
		
		var rentalStartDate = $('#rentalStartDate').val();
		if(validateValue(rentalStartDate)){
			$('#rentalStartDate').html('필수정보입니다.');
			$('#rentalStartDate').addClass('is-invalid');
			$('#rentalStartDate').focus();
			return false;
		}
		
		var rentalEndDate = $('#rentalEndDate').val();
		if(validateValue(rentalEndDate)){
			$('#rentalEndDate').html('필수정보입니다.');
			$('#rentalEndDate').addClass('is-invalid');
			$('#rentalEndDate').focus();
			return false;
		}
		
		var mileageUse = $('#mileageUse').val();
		if(validateValue(mileageUse)){
			$('#mileageUse').html('필수정보입니다.');
			$('#mileageUse').addClass('is-invalid');
			$('#mileageUse').focus();
			return false;
		}
	
		var regionSidoCode = $('#regionSidoCode').val();
		if(regionSidoCode == '시ㆍ도를 선택해주세요.'){
			$('#regionSidoCodeCheck').html('필수정보입니다.');
			$('#regionSidoCode').addClass('is-invalid');
			$('#regionSidoCode').focus();
			return false;
		}
		
		var regionSggCode = $('#regionSggCode').val();
		if(regionSggCode == '시ㆍ군ㆍ구를 선택해주세요.'){
			$('#regionSggCodeCheck').html('필수정보입니다.');
			$('#regionSggCode').addClass('is-invalid');
			$('#regionSggCode').focus();
			return false;
		}
		
		var userAddrDesc = $('#userAddrDesc').val();
		if(validateValue(userAddrDesc)) {
			$('#userAddrDescCheck').html('필수정보입니다.');
			$('#userAddrDesc').addClass('is-invalid');
			$('#userAddrDesc').focus();
			return false;
		}
	
		if($("input[name='payment.paymentType']:checked").val() == '카드'){
			var cardNumber = $('#cardNumber').val();
			if(validateValue(cardNumber)){
				$('#cardNumber').html('필수정보입니다.');
				$('#cardNumber').addClass('is-invalid');
				$('#cardNumber').focus();
				return false;
			}
		}
		else if($("input[name='payment.paymentType']:checked").val() == '통장'){
			var accountNumber = $('#accountNumber').val();
			if(validateValue(accountNumber)){
				$('#accountNumber').html('필수정보입니다.');
				$('#accountNumber').addClass('is-invalid');
				$('#accountNumber').focus();
				return false;
			}
		}
		
		if(!addrJ.test(userAddrDesc)){
			$('#userAddrDescCheck').html('올바른 상세주소를 적어주세요.');
			$('#userAddrDesc').addClass('is-invalid');
			$('#userAddrDesc').focus();
			return false;	
		}
		
		
		
		$('#paymentForm').submit();
		
	});
		
});
		
		
		
				
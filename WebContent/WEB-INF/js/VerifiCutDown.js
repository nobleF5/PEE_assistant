$(function() {
	var SECNOD = 59;

	$(":button").on(
			'click',
			function() {
				var seconds = SECNOD;
				var $bnt = $(":button");
				$bnt.attr("disabled", "disabled");
				var codeIntervalId = window.setInterval(function() {
					
					$bnt.val( Math.floor(seconds % 60) + "秒" + "后重新发送");

					if (seconds == 0) {
						window.clearInterval(codeIntervalId);
						seconds = SECNOD;

						$bnt.val("获取验证码");
						$bnt.removeAttr("disabled");

						return false;
					}

					seconds--;
				}, 1000);

			});
});
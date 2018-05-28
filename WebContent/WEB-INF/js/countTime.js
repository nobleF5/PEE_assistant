
			$(document).ready(function() {
				window.setInterval(showtime(),12*60*60000)
			});

			function daysBetween(DateOne, DateTwo) {
				var OneMonth = DateOne.substring(5, DateOne.lastIndexOf('-'));
				var OneDay = DateOne.substring(DateOne.length, DateOne.lastIndexOf('-') + 1);
				var OneYear = DateOne.substring(0, DateOne.indexOf('-'));

				var TwoMonth = DateTwo.substring(5, DateTwo.lastIndexOf('-'));
				var TwoDay = DateTwo.substring(DateTwo.length, DateTwo.lastIndexOf('-') + 1);
				var TwoYear = DateTwo.substring(0, DateTwo.indexOf('-'));

				var cha = ((Date.parse(OneMonth + '/' + OneDay + '/' + OneYear) - Date.parse(TwoMonth + '/' + TwoDay + '/' + TwoYear)) / 86400000);
				return Math.abs(cha);
			}
			Date.prototype.format = function(fmt) {
				var o = {
					"M+": this.getMonth() + 1, //月份 
					"d+": this.getDate(), //日 
					"h+": this.getHours(), //小时 
					"m+": this.getMinutes(), //分 
					"s+": this.getSeconds(), //秒 
					"q+": Math.floor((this.getMonth() + 3) / 3), //季度 
					"S": this.getMilliseconds() //毫秒 
				};
				if(/(y+)/.test(fmt)) {
					fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
				}
				for(var k in o) {
					if(new RegExp("(" + k + ")").test(fmt)) {
						fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
					}
				}
				return fmt;
			}

			function countTime() {
				var myDate = new Date();
				var endDate = new Date('2018/12/22 00:00');
				var time1 = myDate.format("yyyy-MM-dd");
				var time2 = endDate.format("yyyy-MM-dd");
				var duringTime = daysBetween(time1, time2);
				return duringTime;
			}
			function showtime(){
//				console.log($("#countDownNumber").html())
				$("#countDownNumber").html(countTime());
			}
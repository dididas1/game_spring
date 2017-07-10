/**
 * 
 */

function checkDate(stardate,enddate) {
	var stararr=stardate.split('-');
	var endarr=enddate.split('-');
	
	var startDateCompare = new Date(stararr[0], stararr[1], stararr[2]);
    var endDateCompare = new Date(endarr[0], endarr[1], endarr[2]);
     
	if(startDateCompare.getTime()>=endDateCompare.getTime()){
		return false
	}else{
		 return true;
	}
}

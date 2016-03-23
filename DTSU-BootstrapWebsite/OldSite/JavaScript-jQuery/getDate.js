window.onload = function () {
    var years = [1936, 1943, 1971, 1976];
    var ids = ['myResult', 'myResult1', 'myResult2', 'myResult3'];
    var num = 0;
    while (num <= 3) {
        var currentDate = new Date();
        var year = currentDate.getFullYear();
        var yearDiff = (years[num]).years().ago().getFullYear();
        document.getElementById(ids[num]).innerHTML = 'Approximatly ' + yearDiff + ' Years Ago';
        num++;
    }
};
$(document).ready(function() {
        $('#example').dataTable( {
        	//dom : 'lpf',
        	//pagingType : "simple",
        	"lengthMenu" : [ [10, 25, 50, 100, -1], [10, 25, 50, 100, "All"]],
        	//"columnDefs" : [ {"targets":8, "orderable":false,}],
         	"columns": [
         		{ "data": "rank", defaultContent: ''},
                { "data": "userID" },
                { "data": "userName" },
                { "data": "completionResult" },
                { "data": "executionResult" },
                { "data": "score" },
                { "data": "language" },
                { "data": "submissionDate"}
            ],
            drawCallback: function () {
              api = this.api();
              var arr1 = api.columns(5).data()[0];  //get array of column 6 (score)
              var set = new Set(arr1);
              //console.log(set);
              //console.log(arr1);
              var arr = [...set];
              //console.log("final array!!!!!")
              //console.log(arr);
              var sorted = arr.slice().sort(function(a,b){return b-a});
              var ranks = arr.slice().map(function(v){ return sorted.indexOf(v)+1 });
              //console.log(sorted);
              //console.log("final ranks!!!!!")
              //console.log(ranks);
              // interate through each row
              api.rows().every( function ( rowIdx, tableLoop, rowLoop ) {
                var data = this.data();
                console.log(data.userID, data.score, ranks[arr.indexOf(data.score)]);
                data.rank = ranks[arr.indexOf(data.score)];  //set the rank column = the array index of the extn in the ranked array
                //$('#example tbody tr:eq('+rowIdx+') td:eq(4)').html(ranks[arr.indexOf(data.extn)]);
                this.data(data);
              } );
            api.rows().invalidate();
          } 
        } );
    } );
    

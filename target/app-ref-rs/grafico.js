      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawVisualization);

      function drawVisualization() {
        // Some raw data (not necessarily accurate)
        var data = google.visualization.arrayToDataTable([
         ['Dias', '01/05/2004', '01/05/2004', '01/05/2004', '01/05/2004', '01/05/2004', '01/05/2004'],
         ['Orçamento com sucesso',  165,      938,         522,             998,           450,      914.6],
         ['Orçamento com falhas',  135,      1120,        599,             1268,          288,      682.54],
         ['Transmissões com sucesso',  157,      1167,        587,             807,           397,      623.67],
         ['Transmissões com falhas',  139,      1110,        615,             968,           215,      609.4],
         ['% de conversao',  90,      691,         629,             1026,          366,      569.6]
      ]);

 
    var options = {
      is3D: true,
      title : 'Emissão Produtos R1',
      //vAxis: {title: 'Cups'},


 vAxes: {0: {viewWindowMode:'explicit',
                    
                      gridlines: {color: 'transparent'},
                      },
                  1: {gridlines: {color: 'transparent'},
                      format:"R$ ###,###"},
                  },


      hAxis: {},
     // yAxis: {title: 'Total',format:'R$ ###,###'},
      seriesType: 'bars',
     //  series: {5: {type: 'line'}}
        series: {
           // 4:{ type: "bars", targetAxisIndex: 4, format:"%##" },
            5: { type: "line", targetAxisIndex: 1,format:'R$ ###,###'}
        }
    };

    var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
    chart.draw(data, options);
  }
$(document).ready(
    function() {
        // get request
        $("#getBoughtItems").click(function (event) {

            event.preventDefault();
            ajaxGet();

        });
        // get
        function ajaxGet() {
            $.ajax( {
                type: "GET",
                url : "getBoughtItems",
                success: function (result) {
                    if (result.status == "success") {
                        $("#tableBody").empty();
                        var itemList = "";
                        $.each(result.data, function (i, item) {
                            var tempTBody = "<tr><td id='itemBought'><input type='checkbox' ";
                            if (item.bought) {
                                tempTBody += "checked='checked' ";
                            }
                            tempTBody += "></td><td id='itemId' style=\"visibility: hidden;\">" + item.id +
                                        "</td><td id='itemName'><input type='text' name='name' value='" + item.name + "'></td></tr>";
                            $("#tableBody").append(tempTBody);
                        })

                        //
                    } else {
                        console.log("ERROR");
                    }
                },
                error : function (e) {
                    console.log(e.toString());
                }
            });
        }
    }
)
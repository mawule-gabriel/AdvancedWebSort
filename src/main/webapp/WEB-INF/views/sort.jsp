<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <title>Sorting Algorithms</title>
    <style>
        body {
            background-color: #f8f9fa;
        }
        .result-box {
            background-color: #ffffff;
            border: 1px solid #ced4da;
            border-radius: 0.5rem;
            padding: 1rem;
            margin-top: 1rem;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
<div class="container my-5">
    <h1 class="text-center mb-4">Sorting Algorithms</h1>

    <form id="sortingForm">
        <div class="mb-3">
            <label for="data" class="form-label">Enter Array (comma-separated):</label>
            <input type="text" class="form-control" id="data" name="data" placeholder="e.g., 5, 3, 8, 1" required>
        </div>
        <div class="mb-3">
            <label for="algorithm" class="form-label">Select Algorithm:</label>
            <select class="form-select" id="algorithm" name="algorithm">
                <option value="quickSort">QuickSort</option>
                <option value="mergeSort">MergeSort</option>
                <option value="heapSort">HeapSort</option>
                <option value="radixSort">RadixSort</option>
                <option value="bucketSort">BucketSort</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary"><i class="fas fa-sort-amount-down"></i> Sort</button>
    </form>

    <div class="result-box" id="resultBox">
        <p class="text-warning" id="initialMessage">Please enter data and select an algorithm to see the result.</p>
    </div>

</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(document).ready(function () {

        const $resultBox = $('#resultBox');

        $('#sortingForm').submit(function (event) {
            event.preventDefault();

            const algorithm = $('#algorithm').val();  // This fetches the selected algorithm
            const data = $('#data').val();  // Get the entered data

            if (!data.trim()) {
                alert("Please enter data.");
                return;
            }

            // Display the 'Processing...' message
            $resultBox.html('<p class="text-info">Processing...</p>');

            try {
                // Prepare the request data, converting the comma-separated string into an array of integers
                const requestData = {
                    data: data.split(',').map(function(item) {
                        const num = parseInt(item.trim());
                        if (isNaN(num)) {
                            throw new Error('Invalid number format');
                        }
                        return num;
                    })
                };

                // Send the AJAX request
                $.ajax({
                    url: 'http://localhost:8080/AdvancedWebSort_war/api/sort/' + algorithm,
                    method: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify(requestData),
                    success: function(response) {
                        console.log('Response received:', response);

                        // Ensure the response is correctly parsed if needed
                        const parsedResponse = typeof response === 'string' ? JSON.parse(response) : response;

                        // Ensure the response contains necessary values
                        const processedResponse = {
                            inputData: parsedResponse?.inputData,
                            sortedData: parsedResponse?.sortedData,
                            algorithmName: parsedResponse?.algorithmName,
                            executionTime: parsedResponse?.executionTime
                        };

                        if (!processedResponse.inputData || !processedResponse.sortedData ||
                            !processedResponse.algorithmName || processedResponse.executionTime === undefined) {
                            throw new Error('Invalid response format');
                        }

                        // Create the HTML to display the result
                        const resultHtml = '<div class="alert alert-success">' +
                            '<h4>Results:</h4>' +
                            '<p><strong>Original Data:</strong> ' + processedResponse.inputData.join(', ') + '</p>' +
                            '<p><strong>Sorted Data:</strong> ' + processedResponse.sortedData.join(', ') + '</p>' +
                            '<p><strong>Algorithm:</strong> ' + processedResponse.algorithmName + '</p>' +
                            '<p><strong>Execution Time:</strong> ' + processedResponse.executionTime + ' nanoseconds</p>' +
                            '</div>';
                        $resultBox.html(resultHtml);
                    },
                    error: function(xhr, status, error) {
                        console.error('Error details:', {
                            status: status,
                            error: error,
                            response: xhr.responseText
                        });
                        $resultBox.html(
                            '<div class="alert alert-danger">' +
                            '<h4>Error:</h4>' +
                            '<p>An error occurred while processing your request.</p>' +
                            '<p>Please check the console for more details.</p>' +
                            '</div>'
                        );
                    }
                });
            } catch (e) {
                $resultBox.html(
                    '<div class="alert alert-danger">' +
                    '<h4>Error:</h4>' +
                    '<p>' + e.message + '</p>' +
                    '<p>Please ensure all input values are valid numbers.</p>' +
                    '</div>'
                );
            }
        });
    });
</script>

</body>
</html>

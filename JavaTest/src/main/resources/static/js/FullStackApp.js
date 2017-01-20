var app = angular.module('FullStackApp', [])
app.factory('SharedItems', function () {
    var sharedList = {
        employees: [{}],
        departments: [{}]
    };

    return {
        getSharedList: function() { return sharedList; },
        add: function (item, listName) {
            //var addList = sharedList[listName];
            if (typeof sharedList[listName] !== 'undefined') {
                sharedList[listName].push(item);
            }
        },

        get: function (listName) {
            //var getList = sharedList[listName];
            if (typeof sharedList[listName] !== 'undefined') {
                return sharedList[listName];
            }
        },
        swap: function(listName, items) {
            //var swapList = sharedList[listName];
            if (typeof sharedList[listName] !== 'undefined') {
                sharedList[listName] = items;
            }
        }
    }
});


app.controller('employees', function($scope, $http, SharedItems) {
    $scope.$on('departmentsUpdate', function() {
        $scope.departments = SharedItems.get('departments');
    })
    
    $scope.updateEmployee = function() {
        console.log('perform update Employee')
        var employeeModel = {id: 1, salary: 20001, departmentId: 1};

        $http({
            url: '/employees/update', 
            method: 'PUT',
            data: $.param(employeeModel)
        }).success(function(data) {
            SharedItems.swap('employees',data);
            $scope.employees = SharedItems.get('employees')
        })
    }
    $http.get('/employees/').success(function(data) {
        SharedItems.swap('employees',data)
        $scope.employees = SharedItems.get('employees');
    })
})
app.controller('departments', function($scope, $http, SharedItems) {
    $scope.addDepartement = function() {
        $http({
            url: '/departments/create', 
            method: 'POST',
            data: $.param({name: $scope.departmentName})
        }).success(function(data) {
            //$scope.departments = data;
            SharedItems.swap('departments',data)
            $scope.departments = SharedItems.get('departments');
            $scope.$broadcast('departmentsUpdate');
            $scope.departmentName = '';
        })
    }
    
    $http.get('/departments/').success(function(data) {
        //$scope.departments = data;
        SharedItems.swap('departments', data);
        $scope.departments = SharedItems.get('departments')
        $scope.$broadcast('departmentsUpdate');
    })
});

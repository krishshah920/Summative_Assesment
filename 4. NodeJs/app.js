
const express = require('express');
const bodyParser =  require('body-parser');
const http = require('http');
const request = require('request');
const ejs = require('ejs');
var mysql = require("mysql");
const app = express();
const jsdom = require("jsdom");
const { JSDOM } = jsdom;
const axios = require('axios');
var Username = "";
app.use(bodyParser.urlencoded({extended:true}));
app.set('view engine','ejs');
app.use(express.static('public'));

app.get("/",function(req,res){
    res.render("Menu");
});

app.get("/EmployeeRegistration",function(req,res){
    res.render("EmployeeRegistration");
});

app.post("/EmployeeRegistration",function(req,res){
   var firstName = req.body.firstName;
   var lastName = req.body.lastName;
   var EmpId = firstName.substring(0,3) + lastName.substring(0,3);
   var username = req.body.username;
   var password = req.body.password;
   var contact = req.body.contact;
   var address = req.body.address;

   var sql = "insert into Employee values('"+EmpId+"','"+firstName+"','"+lastName+"','"+username+"','"+password+"','"+address+"','"+contact+"')";
   connection.query(sql,function(err,row,fields){
    if(err) throw err;
    console.log("Successfully added");
   })

   
    res.render("SuccessfullInsertion");

})

function makeGetRequest(username) {

    let payload = {Username:username };

    let res = axios.post('/localhost:3000/demo', payload);

    let data = res.data;
    console.log(data);
}

app.get("/Login",function(req,res){
 res.render("Login");
});

app.post("/Login",function(req,res){
    Username = req.body.username;
    var password = req.body.password;
    console.log("User", Username);
    res.redirect("/UsersList");
});

var obj = {};
app.get("/UsersList",function(req,res){
    connection.query('SELECT * FROM Employee', function(err, result) {

        if(err){
            throw err;
        } else {
            obj = {print: result};
            res.render('UsersList', obj);
        }
        console.log(Username);
});
});
app.post("/UsersList",function(req,res){

    var sql = 'Delete from Employee where username="'+Username+'"';
    connection.query(sql,function(err,row,fields){
        if(err) throw err;
        else{
        console.log("Successfully deleted");
        console.log("Username",Username);
        res.render("SuccessfullyDeleted");
        }
       })
})

var connection = mysql.createConnection({
    host: "localhost",
    user:"root",
    password:"root",
    database:"Employee"
});

connection.connect(function(err) {
    if(err) throw err;

    console.log("connected");
})

app.listen(3000,function(){
    console.log("server is running on port 3000");
});
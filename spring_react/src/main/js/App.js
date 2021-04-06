'use strict'

const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./Client')

class App extends React.Component {
  
  
    constructor(props) {
      super(props);
    //   this.deleteRecord = this.deleteRecord.bind(this);
    //   this.createRecord = this.createRecord.bind(this);
      this.state = {
          criterias: [],
      };
   }

//basic page start
   componentDidMount(){
       client({method: 'GET', path: '/api/criterias'}).done(res => {this.setState({criterias: res.entity._embedded.criterias});
    });
   }
 
   render(){
       return(
           <RecordList criterias={this.state.criterias}/>
       )
   }
}

//get the list
class RecordList extends React.Component{

    render(){
        const criterias = this.props.criterias.map(
            criteria => <Criteria key={criteria._links.self.href} criteria={criteria}/> );

        return (
            <table>
                <tbody>
                    <tr>
                    <th>Domain Name</th>
                    <th>Cloud Provider</th>
                    <th>Service(s)</th>
                    <th>Existing Component</th>
                    </tr>
                    {criterias}
                </tbody>
            </table>
        )
        
    }

}

//condition[]
class Criteria extends React.Component{
    render(){
        return(
            <tr>
                <td>{this.props.criteria.domain}</td>
                <td>{this.props.criteria.cloudProvider}</td>
                <td>{this.props.criteria.services}</td>
                <td>{this.props.criteria.existingComponent}</td>
            </tr>
        )
    }
}
//basic page end

//   componentDidMount() {
//     this.loadListfromdatabase();
//   }
  

//   loadListfromdatabase() {
//       fetch('http://localhost:8080/api/criterias') 
//       .then((response) => response.json()) 
//       .then((responseData) => { 
//           this.setState({ 
//               conditions: responseData._embedded.criterias, 
//           }); 
//       });     
//   } 
  
//   // Delete 
//   deleteRecord(criteria) {
//       fetch (criteria._links.self.href,
//       { method: 'DELETE',})
//       .then( 
//           res => this.loadListfromdatabase()
//       )
//       .catch( err => cosole.error(err))                
//   }  
  
//   // Create 
//   createRecord(criteria) {
//       fetch('http://localhost:8080/api/criterias', {
//           method: 'POST',
//           headers: {
//             'Content-Type': 'application/json',
//           },
//           body: JSON.stringify(criteria)
//       })
//       .then( 
//           res => this.loadListfromdatabase()
//       )
//       .catch( err => cosole.error(err))
//   }
  
//   render() {
//     return (
//        <div>
//           <Form createRecord={this.createRecord}/>
//           <Table deleteRecord={this.deleteRecord} conditions={this.state.criterias}/> 
//        </div>
//     );
//   }
// }
    	
// class Table extends React.Component {
//     constructor(props) {
//         super(props);
//     }
    
//     render() {
//     var criterias = this.props.criterias.map(criteria =>
//         <criteria key={criteria._links.self.href} createRecord={criteria} deleteRecord={this.props.deleteRecord}/>
//     );

//     return (
//       <div>
//       <table className="table table-striped">
//         <thead>
//           <tr>
//             <th>Domain Name</th>
//             <th>Cloud Provider</th>
//             <th>Services</th>
//             <th>Exisitng Component</th>
//           </tr>
//         </thead>
//         <tbody>{criterias}</tbody>
//       </table>
//       </div>);
//   }
// }
        
// class criteria extends React.Component {
//     constructor(props) {
//         super(props);
//         this.deleteRecord = this.deleteRecord.bind(this);
//     }

//     deleteRecord() {
//         this.props.deleteRecord(this.props.criteria);
//     } 
 
//     render() {
//         return (
//           <tr>
//             <td>{this.props.criteria.domain}</td>
//             <td>{this.props.criteria.cloudProvider}</td>
//             <td>{this.props.criteria.services}</td>
//             <td>{this.props.criteria.existingComponent}</td>
//             <td>
//                 <button className="btn btn-danger" onClick={this.deleteRecord}>Delete</button>
//             </td>
//           </tr>
//         );
//     } 
// }

// class Form extends React.Component {
//     constructor(props) {
//         super(props);
//         this.state = {domain: '', cloudProvider: '', services: '', existingComponent: ''};
//         this.handleSubmit = this.handleSubmit.bind(this);   
//         this.handleChange = this.handleChange.bind(this);     
//     }

//     handleChange(event) {
//         console.log("Domain: " + event.target.domain + " VALUE: " + event.target.value)
//         this.setState(
//             {[event.target.domain]: event.target.value}
//         );
//         this.setState(
//             {[event.target.cloudProvider]: event.target.value}
//         );
//         this.setState(
//             {[event.target.services]: event.target.value}
//         );
//         this.setState(
//             {[event.target.existingComponent]: event.target.value}
//         );
//     }    
    
//     handleSubmit(event) {
//         event.preventDefault();
//         console.log("DomainName: " + this.state.domain);
//         var newRecord = {domain: this.state.domain, cloudProvider: this.state.cloudProvider, 
//                           services: this.state.services, existingComponent: this.state.existingComponent};
//         this.props.createRecord(newRecord);        
//     }
    
//     render() {
//         return (
//             <div className="panel panel-default">
//                 <div className="panel-heading">Create student</div>
//                 <div className="panel-body">
//                 <form className="form-inline">
//                     <div className="col-md-2">
//                         <input type="text" placeholder="domain" className="form-control"  name="domain" onChange={this.handleChange}/>    
//                     </div>
//                     <div className="col-md-2">       
//                         <input type="text" placeholder="cloudProvider" className="form-control" name="cloudProvider" onChange={this.handleChange}/>
//                     </div>
//                     <div className="col-md-2">
//                         <input type="text" placeholder="services" className="form-control" name="services" onChange={this.handleChange}/>
//                     </div>
//                     <div className="col-md-2">
//                         <input type="text" placeholder="existingComponent" className="form-control" name="existingComponent" onChange={this.handleChange}/>
//                     </div>

//                     <div className="col-md-2">
//                         <button className="btn btn-success" onClick={this.handleSubmit}>Save</button>   
//                     </div>        
//                 </form>
//                 </div>      
//             </div>
         
//         );
//     }
// }

ReactDOM.render(<App />, document.getElementById('react') );
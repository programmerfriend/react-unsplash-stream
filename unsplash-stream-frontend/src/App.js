import React, { useState } from 'react';
import logo from './logo.svg';
import './App.css';

function App() {
  const evtSource = new EventSource("http://localhost:8080/images/latest");

  evtSource.onmessage = function(event) {
    console.log(event.data);
    setEvents(events.concat(JSON.parse(event.data)))
  };

  const [events, setEvents] = useState([]);


  return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo"/>
          <Link/>
        </header>
        <EventList events={events}/>
      </div>
  );
}

const Link = () => (
    <a
        className="App-link"
        href="https://reactjs.org"
        target="_blank"
        rel="noopener noreferrer"
    >
      Learn React
    </a>
);

const EventList = ({events}) => (
    <div>
      {events.map((value, index) => {
        return <EventDiv key={index} event={value}/>
      })}
    </div>
);

const EventDiv = ({event}) => (
    <div>
      <p>by {event.creator}</p>
      <img src={event.previewUrl} alt={"test"}/>
    </div>
);

export default App;

import React from 'react';
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';

const Packages = ({ packages }) => {
  return (
    <div className="col">
      {packages.map((pack) => (
        <div className="col-md-4 mb-4" key={pack.id}>
          <Card style={{ width: '18rem' }}>
            <Card.Body>
              <Card.Title><h1>fg</h1></Card.Title>
              <Card.Text>{pack.pDescription}</Card.Text>
            </Card.Body>
          </Card>
          <Card style={{ width: '18rem' }}>
            <Card.Img variant="top" src={pack.imageUrl} alt="Card image" />
            <Card.Body>
              <Card.Title>{pack.pName}</Card.Title>
              <Card.Text>{pack. pDate}</Card.Text>
              <Card.Text>{pack.startAt}</Card.Text>
              <Card.Text>{pack.endAt}</Card.Text>
              <Card.Text>{pack.location}</Card.Text>
              <Card.Text>{pack. activities}</Card.Text>
              <Button variant="primary">Book Now</Button>
            </Card.Body>
            
          </Card>
        </div>
        
      ))}
    </div>
  );
};

export default Packages;

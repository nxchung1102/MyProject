import React from 'react';
import Carousel from 'react-material-ui-carousel';
import Item from './item.jsx';
import imageSlider from '../../fakeSlide.json';

function CarouselStore() {
  return (
    <Carousel className="carouselStore">
      {imageSlider.map((item) => (
        <Item key={item.id} item={item} />
      ))}
    </Carousel>
  );
}

export default CarouselStore;

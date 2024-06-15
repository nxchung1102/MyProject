import React from 'react';
import CarouselStore from './index.jsx';
import './CarouselStore.scss';

export default function DisplayBanner() {
  return (
    <div className="slide">
      <div className="item1">
        <CarouselStore />
      </div>
      <div className="item2">
        <div className="box1">
          <img
            src="https://cdn.vietnambiz.vn/171464876016439296/2020/11/24/female-sneakers-run-pink-background-fashion-stylish-sport-shoes-close-up77190-2501-16061580250661124936551.jpg"
            alt=""
          />
        </div>
        <div className="box2">
          <img
            src="https://img.pikbest.com/wp/202347/roller-skating-vibrant-pink-skates-and-glasses-surrounded-by-colorful-balls-on-blue-background-3d-rendering_9770442.jpg!f305cw"
            alt=""
          />
        </div>
      </div>
    </div>
  );
}

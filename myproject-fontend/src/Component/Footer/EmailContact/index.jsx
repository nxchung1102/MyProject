import classNames from 'classnames';
import ApprovalIcon from '@mui/icons-material/Approval';
import nezuko from '../../../image/nezuko.gif';
import './EmailContact.scss';

import React from 'react';

export default function EmailContact() {
  return (
    <div>
      <div className={classNames('tooltip-container')}>
        <span className={classNames('tooltip')}>nxchung1102@gmail.com</span>
        <img src={nezuko} alt="nezuko :3" id="nezuko" />
      </div>
    </div>
  );
}

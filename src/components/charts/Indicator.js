import React, { Component } from 'react';
import Loader from '../app/Loader';

class Indicator extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        const {value, caption, loader, fullWidth} = this.props;
        
        if(loader) return <div className="indicator"><Loader /></div>;
        
        return (
            <div className="indicator" style={fullWidth ? {width: '100%'} : {}}>
                <div className="indicator-value">{value}</div>
                <div className="indicator-kpi-caption">{caption}</div>
            </div>
        );
    }
}

export default Indicator;

import React, { PureComponent } from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import counterpart from 'counterpart';

import { abortWorkflowRequest } from '../../api/launchers';
import { redirectToAppLaunchers } from '../../actions/RoutingActions';
import ConfirmButton from '../activities/confirmButton/ConfirmButton';

class AbortButton extends PureComponent {
  onUserConfirmed = () => {
    const { wfProcessId, appId, redirectToAppLaunchers } = this.props;

    abortWorkflowRequest(wfProcessId).then(redirectToAppLaunchers(appId));
  };

  render() {
    const caption = counterpart.translate('activities.confirmButton.abort.caption');

    return (
      <div className="mt-5">
        <ConfirmButton
          isCancelMode={true}
          isUserEditable={true}
          caption={caption}
          onUserConfirmed={this.onUserConfirmed}
        />
      </div>
    );
  }
}

const mapStateToProps = (state) => {
  const { activeApplication } = state.applications;

  return {
    appId: activeApplication ? activeApplication.id : null,
  };
};

AbortButton.propTypes = {
  wfProcessId: PropTypes.string.isRequired,
  appId: PropTypes.string.isRequired,
  redirectToAppLaunchers: PropTypes.func.isRequired,
};

export default connect(mapStateToProps, { redirectToAppLaunchers })(AbortButton);

-- 2023-07-05T05:36:37.371649700Z
INSERT INTO C_Flatrate_Transition (AD_Client_ID,AD_Org_ID,C_Calendar_Contract_ID,C_Flatrate_Transition_ID,Created,CreatedBy,DocAction,DocStatus,EndsWithCalendarYear,IsActive,IsAutoCompleteNewTerm,IsNotifyUserInCharge,Name,Processed,Processing,TermDuration,TermDurationUnit,TermOfNotice,TermOfNoticeUnit,Updated,UpdatedBy) VALUES (1000000,1000000,1000000,540037,TO_TIMESTAMP('2023-07-05 08:36:37.36','YYYY-MM-DD HH24:MI:SS.US'),100,'CO','DR','N','Y','N','N','Default value for modular contract','N','N',0,'year',0,'day',TO_TIMESTAMP('2023-07-05 08:36:37.36','YYYY-MM-DD HH24:MI:SS.US'),100)
;

-- 2023-07-05T05:36:48.751901800Z
UPDATE C_Flatrate_Transition SET TermDuration=1,Updated=TO_TIMESTAMP('2023-07-05 08:36:48.751','YYYY-MM-DD HH24:MI:SS.US'),UpdatedBy=100 WHERE C_Flatrate_Transition_ID=540037
;

-- 2023-07-05T05:37:18.149332400Z
INSERT INTO AD_WF_Process (AD_Client_ID,AD_Org_ID,AD_Table_ID,AD_User_ID,AD_WF_Process_ID,AD_WF_Responsible_ID,AD_Workflow_ID,Created,CreatedBy,IsActive,Priority,Processed,Processing,Record_ID,Updated,UpdatedBy,WF_Initial_User_ID,WFState) VALUES (1000000,1000000,540331,100,540371,101,540028,TO_TIMESTAMP('2023-07-05 08:37:18.009','YYYY-MM-DD HH24:MI:SS.US'),100,'Y',0,'N','N',540037,TO_TIMESTAMP('2023-07-05 08:37:18.009','YYYY-MM-DD HH24:MI:SS.US'),100,100,'ON')
;

-- 2023-07-05T05:37:18.191101800Z
UPDATE AD_WF_Process SET AD_Issue_ID=NULL, AD_Table_ID=540331, AD_User_ID=100, AD_WF_Responsible_ID=101, AD_Workflow_ID=540028, Priority=0, Processed='Y', Record_ID=540037, TextMsg=NULL, WF_Initial_User_ID=100, WFState='CC',Updated=TO_TIMESTAMP('2023-07-05 08:37:18.19','YYYY-MM-DD HH24:MI:SS.US'),UpdatedBy=100 WHERE AD_WF_Process_ID=540371
;

-- 2023-07-05T05:37:18.298037600Z
INSERT INTO AD_WF_Activity (AD_Client_ID,AD_Org_ID,AD_Table_ID,AD_User_ID,AD_WF_Activity_ID,AD_WF_Node_ID,AD_WF_Process_ID,AD_WF_Responsible_ID,AD_Workflow_ID,Created,CreatedBy,IsActive,Priority,Processed,Processing,Record_ID,Updated,UpdatedBy,WFState) VALUES (1000000,1000000,540331,100,541003,540095,540371,101,540028,TO_TIMESTAMP('2023-07-05 08:37:18.199','YYYY-MM-DD HH24:MI:SS.US'),100,'Y',0,'Y','N',540037,TO_TIMESTAMP('2023-07-05 08:37:18.199','YYYY-MM-DD HH24:MI:SS.US'),100,'CC')
;

-- 2023-07-05T05:37:18.413763400Z
INSERT INTO AD_WF_Activity (AD_Client_ID,AD_Org_ID,AD_Table_ID,AD_User_ID,AD_WF_Activity_ID,AD_WF_Node_ID,AD_WF_Process_ID,AD_WF_Responsible_ID,AD_Workflow_ID,Created,CreatedBy,IsActive,Priority,Processed,Processing,Record_ID,TextMsg,Updated,UpdatedBy,WFState) VALUES (1000000,1000000,540331,100,541004,540094,540371,101,540028,TO_TIMESTAMP('2023-07-05 08:37:18.317','YYYY-MM-DD HH24:MI:SS.US'),100,'Y',0,'Y','N',540037,'Contract Transition 540037',TO_TIMESTAMP('2023-07-05 08:37:18.317','YYYY-MM-DD HH24:MI:SS.US'),100,'CC')
;

-- 2023-07-05T05:37:18.530370400Z
INSERT INTO AD_WF_Activity (AD_Client_ID,AD_Org_ID,AD_Table_ID,AD_User_ID,AD_WF_Activity_ID,AD_WF_Node_ID,AD_WF_Process_ID,AD_WF_Responsible_ID,AD_Workflow_ID,Created,CreatedBy,IsActive,Priority,Processed,Processing,Record_ID,TextMsg,Updated,UpdatedBy,WFState) VALUES (1000000,1000000,540331,100,541005,540093,540371,101,540028,TO_TIMESTAMP('2023-07-05 08:37:18.428','YYYY-MM-DD HH24:MI:SS.US'),100,'Y',0,'Y','N',540037,'Contract Transition 540037',TO_TIMESTAMP('2023-07-05 08:37:18.428','YYYY-MM-DD HH24:MI:SS.US'),100,'CC')
;

-- 2023-07-05T05:37:18.648532900Z
INSERT INTO AD_WF_EventAudit (AD_Client_ID,AD_Org_ID,AD_Table_ID,AD_User_ID,AD_WF_EventAudit_ID,AD_WF_Node_ID,AD_WF_Process_ID,AD_WF_Responsible_ID,Created,CreatedBy,ElapsedTimeMS,EventType,IsActive,Record_ID,Updated,UpdatedBy,WFState) VALUES (1000000,0,540331,100,542130,540095,540371,101,TO_TIMESTAMP('2023-07-05 08:37:18.543','YYYY-MM-DD HH24:MI:SS.US'),100,0,'PC','Y',540037,TO_TIMESTAMP('2023-07-05 08:37:18.543','YYYY-MM-DD HH24:MI:SS.US'),100,'ON')
;

-- 2023-07-05T05:37:18.765743900Z
INSERT INTO AD_WF_EventAudit (AD_Client_ID,AD_Org_ID,AD_Table_ID,AD_User_ID,AD_WF_EventAudit_ID,AD_WF_Node_ID,AD_WF_Process_ID,AD_WF_Responsible_ID,Created,CreatedBy,ElapsedTimeMS,EventType,IsActive,Record_ID,Updated,UpdatedBy,WFState) VALUES (1000000,0,540331,100,542131,540095,540371,101,TO_TIMESTAMP('2023-07-05 08:37:18.662','YYYY-MM-DD HH24:MI:SS.US'),100,0,'SC','Y',540037,TO_TIMESTAMP('2023-07-05 08:37:18.662','YYYY-MM-DD HH24:MI:SS.US'),100,'OR')
;

-- 2023-07-05T05:37:18.878992700Z
INSERT INTO AD_WF_EventAudit (AD_Client_ID,AD_Org_ID,AD_Table_ID,AD_User_ID,AD_WF_EventAudit_ID,AD_WF_Node_ID,AD_WF_Process_ID,AD_WF_Responsible_ID,Created,CreatedBy,ElapsedTimeMS,EventType,IsActive,Record_ID,Updated,UpdatedBy,WFState) VALUES (1000000,0,540331,100,542132,540095,540371,101,TO_TIMESTAMP('2023-07-05 08:37:18.778','YYYY-MM-DD HH24:MI:SS.US'),100,0,'PX','Y',540037,TO_TIMESTAMP('2023-07-05 08:37:18.778','YYYY-MM-DD HH24:MI:SS.US'),100,'CC')
;

-- 2023-07-05T05:37:18.973285500Z
INSERT INTO AD_WF_EventAudit (AD_Client_ID,AD_Org_ID,AD_Table_ID,AD_User_ID,AD_WF_EventAudit_ID,AD_WF_Node_ID,AD_WF_Process_ID,AD_WF_Responsible_ID,Created,CreatedBy,ElapsedTimeMS,EventType,IsActive,Record_ID,Updated,UpdatedBy,WFState) VALUES (1000000,0,540331,100,542133,540094,540371,101,TO_TIMESTAMP('2023-07-05 08:37:18.889','YYYY-MM-DD HH24:MI:SS.US'),100,0,'PC','Y',540037,TO_TIMESTAMP('2023-07-05 08:37:18.889','YYYY-MM-DD HH24:MI:SS.US'),100,'ON')
;

-- 2023-07-05T05:37:19.082171300Z
INSERT INTO AD_WF_EventAudit (AD_Client_ID,AD_Org_ID,AD_Table_ID,AD_User_ID,AD_WF_EventAudit_ID,AD_WF_Node_ID,AD_WF_Process_ID,AD_WF_Responsible_ID,Created,CreatedBy,ElapsedTimeMS,EventType,IsActive,Record_ID,Updated,UpdatedBy,WFState) VALUES (1000000,0,540331,100,542134,540094,540371,101,TO_TIMESTAMP('2023-07-05 08:37:18.983','YYYY-MM-DD HH24:MI:SS.US'),100,0,'SC','Y',540037,TO_TIMESTAMP('2023-07-05 08:37:18.983','YYYY-MM-DD HH24:MI:SS.US'),100,'OR')
;

-- 2023-07-05T05:37:19.195553Z
INSERT INTO AD_WF_EventAudit (AD_Client_ID,AD_Org_ID,AD_Table_ID,AD_User_ID,AD_WF_EventAudit_ID,AD_WF_Node_ID,AD_WF_Process_ID,AD_WF_Responsible_ID,Created,CreatedBy,ElapsedTimeMS,EventType,IsActive,Record_ID,TextMsg,Updated,UpdatedBy,WFState) VALUES (1000000,0,540331,100,542135,540094,540371,101,TO_TIMESTAMP('2023-07-05 08:37:19.092','YYYY-MM-DD HH24:MI:SS.US'),100,12,'PX','Y',540037,'Contract Transition 540037',TO_TIMESTAMP('2023-07-05 08:37:19.092','YYYY-MM-DD HH24:MI:SS.US'),100,'CC')
;

-- 2023-07-05T05:37:19.293472700Z
INSERT INTO AD_WF_EventAudit (AD_Client_ID,AD_Org_ID,AD_Table_ID,AD_User_ID,AD_WF_EventAudit_ID,AD_WF_Node_ID,AD_WF_Process_ID,AD_WF_Responsible_ID,Created,CreatedBy,ElapsedTimeMS,EventType,IsActive,Record_ID,Updated,UpdatedBy,WFState) VALUES (1000000,0,540331,100,542136,540093,540371,101,TO_TIMESTAMP('2023-07-05 08:37:19.207','YYYY-MM-DD HH24:MI:SS.US'),100,0,'PC','Y',540037,TO_TIMESTAMP('2023-07-05 08:37:19.207','YYYY-MM-DD HH24:MI:SS.US'),100,'ON')
;

-- 2023-07-05T05:37:19.411791700Z
INSERT INTO AD_WF_EventAudit (AD_Client_ID,AD_Org_ID,AD_Table_ID,AD_User_ID,AD_WF_EventAudit_ID,AD_WF_Node_ID,AD_WF_Process_ID,AD_WF_Responsible_ID,Created,CreatedBy,ElapsedTimeMS,EventType,IsActive,Record_ID,Updated,UpdatedBy,WFState) VALUES (1000000,0,540331,100,542137,540093,540371,101,TO_TIMESTAMP('2023-07-05 08:37:19.306','YYYY-MM-DD HH24:MI:SS.US'),100,0,'SC','Y',540037,TO_TIMESTAMP('2023-07-05 08:37:19.306','YYYY-MM-DD HH24:MI:SS.US'),100,'OR')
;

-- 2023-07-05T05:37:19.527085800Z
INSERT INTO AD_WF_EventAudit (AD_Client_ID,AD_Org_ID,AD_Table_ID,AD_User_ID,AD_WF_EventAudit_ID,AD_WF_Node_ID,AD_WF_Process_ID,AD_WF_Responsible_ID,Created,CreatedBy,ElapsedTimeMS,EventType,IsActive,Record_ID,TextMsg,Updated,UpdatedBy,WFState) VALUES (1000000,0,540331,100,542138,540093,540371,101,TO_TIMESTAMP('2023-07-05 08:37:19.421','YYYY-MM-DD HH24:MI:SS.US'),100,7,'PX','Y',540037,'Contract Transition 540037',TO_TIMESTAMP('2023-07-05 08:37:19.421','YYYY-MM-DD HH24:MI:SS.US'),100,'CC')
;

-- 2023-07-05T05:37:18.177501100Z
UPDATE C_Flatrate_Transition SET DocStatus='IP',Updated=TO_TIMESTAMP('2023-07-05 08:37:18.177','YYYY-MM-DD HH24:MI:SS.US'),UpdatedBy=100 WHERE C_Flatrate_Transition_ID=540037
;

-- 2023-07-05T05:37:18.186096100Z
UPDATE C_Flatrate_Transition SET DocAction='RE', DocStatus='CO', Processed='Y',Updated=TO_TIMESTAMP('2023-07-05 08:37:18.185','YYYY-MM-DD HH24:MI:SS.US'),UpdatedBy=100 WHERE C_Flatrate_Transition_ID=540037
;

